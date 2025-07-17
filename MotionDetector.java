package motiondetector;

import org.opencv.core.*;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MotionDetector {
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main(String[] args) {
        VideoCapture cam = new VideoCapture(0);
        if (!cam.isOpened()) {
            System.out.println("❌ Camera not found");
            return;
        }

        Mat currentFrame = new Mat();
        Mat previousGray = new Mat();
        Mat currentGray = new Mat();
        Mat diff = new Mat();

        boolean motionDetected = false;
        long lastSavedTime = 0;
        int cooldown = 3000; // 3 seconds between saves

        System.out.println("📷 CameraProject: Auto motion capture started. Press ESC to exit.");

        while (true) {
            if (!cam.read(currentFrame)) break;

            Imgproc.cvtColor(currentFrame, currentGray, Imgproc.COLOR_BGR2GRAY);

            if (previousGray.empty()) {
                currentGray.copyTo(previousGray);
                continue;
            }

            Core.absdiff(previousGray, currentGray, diff);
            Imgproc.threshold(diff, diff, 25, 255, Imgproc.THRESH_BINARY);

            int whitePixels = Core.countNonZero(diff);

            if (whitePixels > 5000) {
                long now = System.currentTimeMillis();
                if (!motionDetected || now - lastSavedTime > cooldown) {
                    motionDetected = true;
                    lastSavedTime = now;

                    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                    String filename = "motion_" + timestamp + ".png";
                    Imgcodecs.imwrite(filename, currentFrame);
                    System.out.println("🚨 Motion Detected — 📸 Saved: " + filename);
                }
            } else {
                motionDetected = false;
            }

            HighGui.imshow("CameraProject - Live Feed", currentFrame);
            if (HighGui.waitKey(10) == 27) break;  // ESC key to quit

            currentGray.copyTo(previousGray);
        }

        cam.release();
        HighGui.destroyAllWindows();
        System.out.println("🛑 Motion detection ended.");
    }
}
