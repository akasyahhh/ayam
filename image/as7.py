def hitung_bmi(berat, tinggi_cm):
    tinggi_m = tinggi_cm / 100  
    bmi = berat / (tinggi_m ** 2)
    return bmi

def menilai_bmi(bmi):
    if bmi < 18.5:
        return "Kurus"
    elif bmi < 24.9:
        return "Normal"
    elif bmi < 29.9:
        return "Gemuk"
    else:
        return "Obesitas"

def main():
    print("|===============================================================|")
    print("|                 P E N G H I T U N G    B M I                  |")
    print("|===============================================================|")
    berat = float(input("Masukkan berat badan (kg): "))
    tinggi_cm = float(input("Masukkan tinggi badan (cm): "))
    
    bmi = hitung_bmi(berat, tinggi_cm)
    status = menilai_bmi(bmi)
    
    print(" |=================================================================|")
    print(" |                           H A S I L                             |")
    print("                  BMI Anda adalah: ",bmi,        "                    ")
    print(" |                Status BMI Anda:",status,"                       |")
    print(" |=================================================================|")

if __name__ == "__main__":
    main()
