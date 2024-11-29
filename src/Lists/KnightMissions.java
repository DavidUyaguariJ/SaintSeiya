package Lists;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class KnightMissions {
    public Node start;
    public int size;

    public KnightMissions() {
        this.start=null;
        this.size=0;
    }

    public void add(SodiacKnight knight, DefaultTableModel tableModel){
        Node newNode= new Node(knight);
        if (start== null){
            start = newNode;
        }else{
            Node actual = start ;
            while (actual.getNext()!=null){
                actual = actual.getNext();
            }
            actual.setNext(newNode);
        }
        size++;
        updateList(tableModel);
    }

    public void bubbleSort(DefaultTableModel tableModel){
        if(start==null||start.getNext()==null)
            return;
        boolean intermediario;
        do{
            intermediario= false;
            Node actual = start;
            Node next = start.getNext();
            while(next!=null){
                if (actual.getKnight().getId()>next.getKnight().getId()){
                    SodiacKnight temp = actual.getKnight();
                    actual.setKnight(next.getKnight());
                    next.setKnight(temp);
                    intermediario=true;

                }
                actual=next;
                next=next.getNext();
            }
        }while(intermediario);
        updateList(tableModel);
    }
    public boolean updateKnight(int id,SodiacKnight sk,DefaultTableModel tableModel){
        bubbleSort(tableModel);
        Node actual = start;
        while (actual!=null) {
            if (actual.getKnight().getId() == id) {
                actual.getKnight().setName(sk.getName());
                actual.getKnight().setRank(sk.getRank());
                actual.getKnight().setConstellation(sk.getConstellation());
                actual.getKnight().setPower(sk.getPower());
                actual.getKnight().setDifficulty(sk.getDifficulty());
                actual.getKnight().setReward(sk.getReward());
                actual.getKnight().calculateKingdomTaxes(sk.getKingdomTaxes());
                actual.getKnight().calculateSanctuaryFund(sk.getSanctuaryFund());
                actual.getKnight().setMission(sk.getMission());
                actual.getKnight().calculateKingdomTaxes(sk.getReward());
                actual.getKnight().calculateSanctuaryFund(sk.getReward());
                updateList(tableModel);
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    public boolean knightExist(int id,DefaultTableModel tableModel){
        bubbleSort(tableModel);
        Node actual = start;
        while (actual!=null) {
            if (actual.getKnight().getId() == id) {
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    public SodiacKnight findKnight(int id,DefaultTableModel tableModel){
        bubbleSort(tableModel);
        Node actual = start;
        while (actual!=null) {
            if (actual.getKnight().getId() == id) {
                return actual.getKnight();
            }
            actual = actual.getNext();
        }
        return null;
    }
    public void updateList(DefaultTableModel tableModel){
        if (start==null){
            JOptionPane.showMessageDialog(null, "Tabla Vacía");
        }else{
            tableModel.setRowCount(0);
            tableModel.addRow(new Object[]{"Codigo", "Nombre", "Rango", "Constelacion", "Nivel de poder","Mision","Dificultad", "Aporte al santuario", "Impuestos del reino", "Recompensa"});
            Node actual = start;
            while (actual!=null){
                SodiacKnight hero = actual.getKnight();
                actual=actual.getNext();
                tableModel.addRow(new Object[]{hero.getId(),hero.getName(),hero.getRank(),hero.getConstellation(),hero.getPower(), hero.getMission(), hero.getDifficulty(),hero.getSanctuaryFund(), hero.getKingdomTaxes(),hero.getReward()});

            }
        }
    }
}
