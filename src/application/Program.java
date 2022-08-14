package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);
        System.out.println("--------------TEST #1: seller findById--------------");
        System.out.println(seller);

        System.out.println("\n--------------TEST #2: seller findByDepartment--------------");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj + "\n");
        }

        System.out.println("\n--------------TEST #3: seller findAll--------------");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("\n--------------TEST #4: seller Insert--------------");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0,department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n--------------TEST #5: seller Update--------------");
        seller = sellerDao.findById(1);
        seller.setName("Marta Wayne");
        sellerDao.update(seller);
        System.out.println("Update completed!");

        System.out.println("\n--------------TEST #5: seller Delete--------------");
        System.out.println("Enter ID: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete complete");

        DepartmentDao depDao = DaoFactory.createDepartmentDao();
        Department dep = depDao.findById(2);
        System.out.println("\n--------------TEST #1: department findById--------------");
        System.out.println(dep);


        System.out.println("\n--------------TEST #2: department findAll--------------");
        List<Department> listDep = depDao.findAll();
        for (Department obj : listDep){
            System.out.println(obj);
        }

        System.out.println("\n--------------TEST #4: department Insert--------------");
        Department newDep = new Department(null, "D3");
        depDao.insert(newDep);
        System.out.println("Inserted! New id = " + newDep.getId());


        System.out.println("\n--------------TEST #5: department Update--------------");
        dep = depDao.findById(6);
        dep.setName("Music");
        depDao.update(dep);
        System.out.println("Update completed!");


        System.out.println("\n--------------TEST #5: department Delete--------------");
        System.out.println("Enter ID: ");
        int idDep = sc.nextInt();
        depDao.deleteById(idDep);
        System.out.println("Delete complete");

        sc.close();

    }
}
