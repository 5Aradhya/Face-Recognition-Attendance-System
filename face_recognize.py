import cv2
from deepface import DeepFace
from attendance_api import mark_attendance
import threading

print("Script started...")

video = cv2.VideoCapture(0)

if not video.isOpened():
    print("Camera could not be opened!")
    exit()

marked_today = set()
current_name = None
processing = False


def recognize_face(frame_copy):
    global current_name, processing
    try:
        small_frame = cv2.resize(frame_copy, (0, 0), fx=0.5, fy=0.5)
        result = DeepFace.find(small_frame, db_path="known_faces", enforce_detection=False)

        if len(result) > 0 and len(result[0]) > 0:
            matched_path = result[0].iloc[0]['identity']
            name = matched_path.split('\\')[-1].split('.')[0]
            current_name = name

            if name not in marked_today:
                mark_attendance(name)
                marked_today.add(name)
        else:
            current_name = None
    except Exception as e:
        print("ERROR:", e)
    processing = False

while True:
    ret, frame = video.read()

    if not ret:
        print("Failed to read frame")
        break

    if not processing:
        processing = True
        frame_copy = frame.copy()
        thread = threading.Thread(target=recognize_face, args=(frame_copy,))
        thread.start()

    if current_name:
        cv2.putText(frame, current_name, (50, 50), cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 0), 2)

    cv2.imshow('Face Recognition', frame)

    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

video.release()
cv2.destroyAllWindows()