import java.awt.*;
import java.util.Scanner;

public abstract class Menu { //Tüm kontrol yönlendirmeleri için temel class
    /**
     * Alt kısımdaki objeler kullanılarak her işlemi bilgisayarda yapılması için
     * objeler üzerinden kullanılması amacı ile burada tutulmaktadır.
     */
    static Person person = new Person();
    static Employee employee = new Employee();
    static Patient patient = new Patient();
    static Management management = new Management();
    static Appointment appointment = new Appointment();

    public static void options() { //İlk yönlendirme metodudur
        System.out.println("Please choose what do you want ?");
        System.out.println("Add (0)\nView(1)\nChange(2)");
        Scanner keyboard = new Scanner(System.in);

        String input = keyboard.nextLine();

        /**
         Alt kısımlarda da bulunan input.mathes methodu ile ilk String belirlenen girdi integer'a parse edilerek
         girdilerde istenilenin dışına çıkılmaması için tasarlanmış ve hemen altındaki if else merdiveni ile
         yönlendirme tasarlanmıştır. Tasarlanan şablonun dışına çıkacak bir girdi sonrası default beep sesi ile
         uyarılması sonrası tekrardan başa dönecek şekilde tasarlanmıştır.
         */
        if (input.matches("[0-2]*")) {
            int choose = Integer.parseInt(input);
            if (choose == 0) {
                System.out.println("For Person(0)\nFor Employee(1)\nFor Management(2)\nFor Patient(3)\n" +
                        "For Appointment(4)");
                input = keyboard.nextLine();
                if (input.matches("[0-4]*")) {
                    choose = Integer.parseInt(input);
                    if (choose == 0) {
                        person.addPerson(); //Kişi bilgilerini ekleme
                        options();
                    } else if (choose == 1) {
                        employee.addEmployee(); //Çalışan bilgilerini ekleme
                        options();
                    } else if (choose == 2) {
                        management.addManagement(); //Yönetimde bulunan çalışan bilgilerini ekleme
                        options();
                    } else if (choose == 3) {
                        patient.addPatient(); //Hasta bilgilerini ekleme
                        options();
                    } else if (choose == 4) {
                        appointment.addAppointment(); //Randevu bilgileri ekleme
                        options();
                    } else {
                        System.out.println("Please enter right number!\n");
                        Toolkit.getDefaultToolkit().beep();
                        options();
                    }
                } else {
                    System.out.println("Please enter right choose!\n");
                    Toolkit.getDefaultToolkit().beep();
                    options();
                }
            } else if (choose == 1) {
                System.out.println("For Person(0)\nFor Employee/Management(1)\nFor Patient(2)\nFor Appointment(3)");
                input = keyboard.nextLine();
                if (input.matches("[0-3]*")) {
                    choose = Integer.parseInt(input);
                    if (choose == 0) {
                        person.viewPerson(); //Kişi bilgilerini görüntüleme
                        options();
                    } else if (choose == 1) {
                        management.viewManagement(); //Çalışan bilgilerini görüntüleme ki varsa yönetimdeki rolünü
                        // belirtir
                        options();
                    } else if (choose == 2) {
                        patient.viewPatient(); //Hasta bilgilerini görüntüleme
                        options();
                    } else if (choose == 3) {
                        appointment.viewAppointment(); //Yönetimdeki kişinin özelliklerini görüntüleme
                        options();
                    } else {
                        System.out.println("Please enter right number!\n");
                        Toolkit.getDefaultToolkit().beep();
                        options();
                    }
                } else {
                    System.out.println("Please enter right choose!\n");
                    Toolkit.getDefaultToolkit().beep();
                    options();
                }
            } else if (choose == 2) {
                System.out.println("For Person(0)\nFor Employee(1)\nFor Management(2)\nFor Patient(3)\nFor Appointment(4)\n");
                input = keyboard.nextLine();
                if (input.matches("[0-4]*")) {
                    choose = Integer.parseInt(input);
                    if (choose == 0) {
                        System.out.println("Please enter what do you want to change :\n" +
                                "Name(0)\nSurname(1)\nDay(2)\nMonth(3)\nYear(4)\nBloodGroup(5)\nAddress(6)\nPhoneNumber(7)\nEmail(8)");
                        input = keyboard.nextLine();
                        if (input.matches("[0-8]*")) {
                            choose = Integer.parseInt(input);
                            if (choose == 0) {
                                person.changeName(); //Kişi ismini düzenleme
                                options();
                            } else if (choose == 1) {
                                person.changeSurname(); //Kişi soyadı düzenleme
                                options();
                            } else if (choose == 2) {
                                person.changeBirthdate_day(); //Kişi doğum günü düzenleme
                                options();
                            } else if (choose == 3) {
                                person.changeBirthdate_month(); //Kişi doğum ayını düzenleme
                                options();
                            } else if (choose == 4) {
                                person.changeBirthdate_year(); //Kişi doğum yılını düzenleme
                                options();
                            } else if (choose == 5) {
                                person.changeBloodGroup(); //Kişi kan grubunu düzenleme
                                options();
                            } else if (choose == 6) {
                                person.changeAddress(); //Kişi adresini düzenleme
                                options();
                            } else if (choose == 7) {
                                person.changePhoneNumber(); //Kişi telefon numarasını düzenleme
                                options();
                            } else if (choose == 8) {
                                person.changeEmail(); //Kişi mail adresini düzenleme
                                options();
                            } else {
                                System.out.println("Please enter right number!");
                                Toolkit.getDefaultToolkit().beep();
                                options();
                            }
                        } else {
                            System.out.println("Please enter right choose!");
                            Toolkit.getDefaultToolkit().beep();
                            options();
                        }
                    } else if (choose == 1) {
                        System.out.println("Please enter what do you want to change :\n" +
                                "Department(0)\nDate of Start Day(1)\nDate of Start Month(2)\n" +
                                "Date of Start Year(3)\nDate of Dismiss Day(4)\nDate of Dismiss Month(5)\nDate of Dismiss Year(6)\n");
                        input = keyboard.nextLine();
                        if (input.matches("[0-6]*")) {
                            choose = Integer.parseInt(input);
                            if (choose == 0) {
                                employee.changeEmployeeDepartment(); //Çalışan departmanını düzenleme
                                options();
                            } else if (choose == 1) {
                                employee.changeDateOfStart_day(); //Çalışan işe giriş gününü düzenleme
                                options();
                            } else if (choose == 2) {
                                employee.changeDateOfStart_month(); //Çalışan işe giriş ayını düzenleme
                                options();
                            } else if (choose == 3) {
                                employee.changeDateOfStart_year(); //Çalışan işe giriş yılını düzenleme
                                options();
                            } else if (choose == 4) {
                                employee.changeDateOfDismiss_day(); //Çalışan işten çıkış gününü düzenleme
                                options();
                            } else if (choose == 5) {
                                employee.changeDateOfDismiss_month(); //Çalışan işten çıkış ayını düzenleme
                                options();
                            } else if (choose == 6) {
                                employee.changeDateOfDismiss_year(); //Çalışan işten çıkış yılını düzenleme
                                options();
                            } else {
                                System.out.println("Please enter right number!");
                                Toolkit.getDefaultToolkit().beep();
                                options();
                            }
                        } else {
                            System.out.println("Please enter right choose!");
                            Toolkit.getDefaultToolkit().beep();
                            options();
                        }
                    } else if (choose == 2) {
                        System.out.println("Please enter what do you want to change :\n" +
                                "Management ID(0)\nManagement Department(1)\n");
                        input = keyboard.nextLine();
                        if (input.matches("[0]*")) {
                            choose = Integer.parseInt(input);
                            if (choose == 0) {
                                management.changeManagementDepartment(); //Çalışan yöneticinin departmanını düzenleme
                                options();
                            } else {
                                System.out.println("Please enter right number!");
                                Toolkit.getDefaultToolkit().beep();
                                options();
                            }
                        } else {
                            System.out.println("Please enter right choose!");
                            Toolkit.getDefaultToolkit().beep();
                            options();
                        }
                    } else if (choose == 3) {
                        System.out.println("Please enter what do you want to change :\n" +
                                "Department(0)\nDate of Hospitality Day(1)\nDate of Hospitality Month(2)\nDate of Hospitality Year(3)\n" +
                                "Date of Leave Day(4)\nDate of Leave Month(5)\nDate of Leave Year(6)\n");
                        input = keyboard.nextLine();
                        if (input.matches("[0-6]*")) {
                            choose = Integer.parseInt(input);
                            if (choose == 0) {
                                patient.changeDepartment(); //Hastanın yattığı departmanı düzenleme
                                options();
                            } else if (choose == 1) {
                                patient.changeDateOfHospitalized_day(); //Hastanın yattığı günü düzenleme
                                options();
                            } else if (choose == 2) {
                                patient.changeDateOfHospitalized_month(); //Hastanın yattığı ayı düzenleme
                                options();
                            } else if (choose == 3) {
                                patient.changeDateOfHospitalized_year(); //Hastanın yattığı yılı düzenleme
                                options();
                            } else if (choose == 4) {
                                patient.changeDateOfLeave_day(); //Hastanın hastaneden ayrıldığı günü düzenleme
                                options();
                            } else if (choose == 5) {
                                patient.changeDateOfLeave_month(); //Hastanın hastaneden ayrıldığı ayı düzenleme
                                options();
                            } else if (choose == 6) {
                                patient.changeDateOfLeave_year(); //Hastanın hastaneden ayrıldığı yılı düzenleme
                                options();
                            } else {
                                System.out.println("Please enter right number!");
                                Toolkit.getDefaultToolkit().beep();
                                options();
                            }
                        } else {
                            System.out.println("Please enter right choose!");
                            Toolkit.getDefaultToolkit().beep();
                            options();
                        }
                    } else if (choose == 4) {
                        System.out.println("Please enter what do you want to change :\n" +
                                "Doctor Name(0)\nDoctor Surname(1)\nAppointment Department(2)\nAppointment Day(3)\n" +
                                "Appointment month(4)\nAppointment Year(5)\n");
                        input = keyboard.nextLine();
                        if (input.matches("[0-5]*")) {
                            choose = Integer.parseInt(input);
                            if (choose == 0) {
                                appointment.changeDoctorName(); //Hastanın radevu doktorunun adını değiştirme
                                options();
                            } else if (choose == 1) {
                                appointment.changeDoctorSurname(); //Hastanın radevu doktorunun soyadını değiştirme
                                options();
                            } else if (choose == 2) {
                                appointment.changeAppointmentDepartment(); //Hastanın randevu departmanını değiştirme
                                options();
                            } else if (choose == 3) {
                                appointment.changeAppointment_day(); //Hastanın randevu günü değiştirme
                                options();
                            } else if (choose == 4) {
                                appointment.changeAppointment_month(); //Hastanın randevu ayını değiştirme
                                options();
                            } else if (choose == 5) {
                                appointment.changeAppointment_year(); //Hastanın randevu yılını değiştirme
                                options();
                            } else {
                                System.out.println("Please enter right number!");
                                Toolkit.getDefaultToolkit().beep();
                                options();
                            }
                        } else {
                            System.out.println("Please enter right choose!");
                            Toolkit.getDefaultToolkit().beep();
                            options();
                        }
                    } else {
                        System.out.println("Please enter right number!");
                        Toolkit.getDefaultToolkit().beep();
                        options();
                    }

                } else {
                    System.out.println("Please enter right choose!");
                    Toolkit.getDefaultToolkit().beep();
                    options();
                }
            } else {
                System.out.println("Please enter right choose!");
                Toolkit.getDefaultToolkit().beep();
                options();
            }
        } else {
            System.out.println("Please enter right choose!");
            Toolkit.getDefaultToolkit().beep();
            options();
        }
    }
}
