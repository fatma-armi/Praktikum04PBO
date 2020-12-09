/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project04;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Isnaini Fatmala
 */
public class PengolahData {
    ArrayList<String> nama = new ArrayList();
    ArrayList<String> nim = new ArrayList();
    ArrayList<Date> tgl = new ArrayList();
    ArrayList<Integer> gender = new ArrayList();
    
    void OlahData() throws ParseException{
        Scanner input = new Scanner(System.in);
        
        while(true){
            System.out.println("-----------------\n   MENU UTAMA\n-----------------");
            System.out.println("1. Tambah Data\n2. Hapus Data\n3. Cari Data\n4. Tampil Data");
            System.out.printf("Pilihan Menu Anda : ");
            int menu = input.nextInt();
            input.nextLine();
            
            if(menu==1){
                System.out.println("-----------------\nMenu Tambah Data\n-----------------");
                System.out.printf("Nama                         : ");
                String name = input.nextLine();
                if(nama.contains(name)!=true){
                    System.out.printf("NIM                          : ");
                    String no = input.nextLine();
                    if(nim.contains(no)!=true){
                        System.out.printf("Tgl (DD-MM-YYYY)             : ");
                        String tang = input.nextLine();
                        Date tanggal = new SimpleDateFormat("DD-MM-YYYY").parse(tang);
                        System.out.printf("Gender (0:laki-laki, 1:perempuan) : ");
                        int gndr = input.nextInt();

                        nama.add(name);
                        nim.add(no);
                        tgl.add(tanggal);
                        gender.add(gndr);
                    }else{
                        System.out.println("Data Sudah Ada");
                    }
                     
                }else{
                        System.out.println("Data Sudah Ada");
                    }

                              
            }
            else if(menu==2){
                System.out.println("-----------------\nMenu Hapus Data\n-----------------");
                System.out.printf("NIM : ");
                String no = input.nextLine();
                
                if(nim.contains(no)==true){
                    int index = Collections.binarySearch(this.nim, no);
                    nama.remove(index);
                    nim.remove(index);
                    tgl.remove(index);
                    gender.remove(index);
                    System.out.println("Data Telah Dihapus");
                }
                else{
                    System.out.println("Data Tidak Ada");
                }
            }
            else if(menu==3){
                System.out.println("-----------------\n   Menu Cari Data\n-----------------");
                System.out.println("1. Berdasarkan Gender\n2. Berdasarkan NIM");
                System.out.printf("Pilihan Menu Anda : ");
                
                int cari = input.nextInt();
                
                if(cari==1){
                    System.out.printf("Masukkan Gender (0:laki-laki, 1:perempuan) : ");
                    int gr = input.nextInt();
                    
                    for(int i = 0; i < this.gender.size(); i++){
                        if(this.gender.get(i)==gr){
                            System.out.println("Nama : "+nama.get(i));
                            System.out.println("NIM : "+nim.get(i));
                            System.out.println("Tgl : "+tgl.get(i));
                            System.out.println("Gender  : "+gender.get(i));
                        }
                    }
                }else if(cari==2){
                    System.out.printf("Masukkan NIM : ");
                    String nomorinduk = input.next();
                    if (nim.contains(nomorinduk) == true){
                        int ind = Collections.binarySearch(this.nim, nomorinduk);
                    
                        String mencariNama = nama.get(ind);
                        String mencariNIM = nim.get(ind);
                        Date mencariTanggal = tgl.get(ind);
                        int mencariGender = gender.get(ind);

                        System.out.println("Nama : "+ mencariNama);
                        System.out.println("NIM : "+ mencariNIM);
                        System.out.println("Tgl : "+ mencariTanggal);
                        System.out.println("Gender : "+ mencariGender);
                        }
                    } else {
                    System.out.println("data tidak ada");
                }
            }
            else if(menu==4){
                System.out.println("-----------------\nMenu Tampil Data\n-----------------");
                for (int i = 0 ; i < this.nama.size(); i++){
                    System.out.println("Nama : "+nama.get(i));
                    System.out.println("NIM : "+nim.get(i));
                    System.out.println("TTL : "+tgl.get(i));
                    System.out.println("Gender  : "+gender.get(i));
                }
                System.out.println("Jumlah mahasiswa : " + nama.size());
            }
        }
    }
}
