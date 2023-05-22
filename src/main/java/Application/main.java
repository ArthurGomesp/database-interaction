package Application;

import DataBase.Db;

import java.sql.Connection;

public class main {
    public static void main(String[] args) {

        Connection conn = Db.getConnetion();
        System.out.println("conexao aberta");
        Db.closeConnetion();
        System.out.println("conexao fechada");

    }
}
