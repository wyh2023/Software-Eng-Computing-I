

def heart_rate_calculation():
    RestingHR = int(input("RestingHR:"))
    age = int(input("Age:"))
    print("Intensity|  Rate")
    print("---------|------")
    intensity = 0.55
    while intensity < 1:
        TargetHeartRate = ((220 - age) - RestingHR) * intensity + RestingHR
        print(str(int(intensity * 100)) + "%      |" + str(int(TargetHeartRate)) + "bpm")
        intensity += 0.05
