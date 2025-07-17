# Motion Detector using Java and OpenCV

This mini project uses **Java + OpenCV 4.11.0** to detect motion through a webcam in real-time.  
When motion is detected, it **captures and saves a snapshot image** with a timestamp.

---

## 📌 Project Objective

To build a lightweight motion detection system that:
- Captures video from webcam
- Detects motion using frame difference
- Saves the snapshot automatically when motion is detected

---

## 🎥 How It Works

- Captures video frames from webcam using `VideoCapture`
- Converts current and previous frames to grayscale
- Uses `absdiff()` to detect pixel-level changes
- Applies threshold to detect significant motion
- Saves a `.png` image whenever motion is detected (with 3-second cooldown)

---

## 🚀 Features

✅ Real-time webcam stream  
✅ Motion detection using grayscale frame difference  
✅ Automatic image saving with timestamp (e.g., `motion_20250717_093210.png`)  
✅ Motion cooldown logic to avoid spamming  
✅ Press `ESC` to exit the live stream

---

## 🧪 Technologies Used

- **Java**
- **OpenCV 4.11.0**
- **Eclipse IDE (or any other IDE)**

---

## 🛠️ How to Set Up

1. ✅ Install **Java JDK**
2. ✅ Download and set up **OpenCV 4.11.0**
   - Add `opencv-411.jar` to project build path
   - Set **native library location** to the folder containing `opencv_java411.dll`
3. ✅ Clone or copy the project files
4. ✅ Run `MotionDetector.java`

---

## 🗃️ Project Structure

MotionDetectorJava/
├── src/
│ └── motiondetector/
│ └── MotionDetector.java
├── lib/
│ └── opencv-411.jar
├── captured_images/
│ └── (Saved images appear here)

yaml
Copy
Edit

---

## 💡 Sample Output

```shell
📷 CameraProject: Auto motion capture started. Press ESC to exit.
🚨 Motion Detected — 📸 Saved: motion_20250717_093210.png
🚨 Motion Detected — 📸 Saved: motion_20250717_093415.png
🛑 Motion detection ended.
🙋 Author
Nikhil
Java Developer | Big Data Enthusiast | Problem Solver
🎓 B.Tech Student | Lovely Professional University

⭐ Give a Star
If you found this project useful or interesting, please ⭐ this repo. Your support matters!
