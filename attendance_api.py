import requests
from datetime import datetime

def mark_attendance(student_name):
    url = "http://localhost:8080/api/attendance/mark"
    
    now = datetime.now()
    current_date = now.strftime("%Y-%m-%d")
    current_time = now.strftime("%H:%M:%S")
    
    data = {
        "studentName": student_name,
        "date": current_date,
        "time": current_time
    }
    
    try:
        response = requests.post(url, json=data)
        
        if response.status_code == 200:
            print(f"Attendance marked successfully for {student_name}")
        else:
            print(f"Failed to mark attendance. Status code: {response.status_code}")
            
    except requests.exceptions.ConnectionError:
        print("Error: Spring Boot server se connect nahi ho paaya. Kya server chal raha hai?")