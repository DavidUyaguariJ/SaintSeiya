import Lists.KnightMissions;
import Lists.SodiacKnight;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MissionsGUI {
    private JPanel pGeneral;
    private JTextField txtName;
    private JComboBox cbxRank;
    private JTextField txtConstellation;
    private JComboBox cbxPower;
    private JTextField txtMission;
    private JComboBox cbxDifficulty;
    private JTable tblResponse;
    private JButton btnRecriute;
    private JTextField txtReward;
    private JTextField txtUpdate;
    private JButton actualizarButton;
    private KnightMissions knightMissions = new KnightMissions();
    private DefaultTableModel tableModel;
    public MissionsGUI() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Rango");
        tableModel.addColumn("Constelacion");
        tableModel.addColumn("Poder");
        tableModel.addColumn("Mision");
        tableModel.addColumn("Dificultad");
        tableModel.addColumn("Recompensa");
        tableModel.addColumn("Aporte Santuario");
        tableModel.addColumn("Impuestos al reino");
        tblResponse.setModel(tableModel);

        btnRecriute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int power=0, difficulty=0;
                double reward=0;
                try{
                    power=Integer.parseInt(cbxPower.getSelectedItem().toString());
                    difficulty=Integer.parseInt(cbxDifficulty.getSelectedItem().toString());
                    reward=Double.parseDouble(txtReward.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                SodiacKnight sk= new SodiacKnight(
                        txtName.getText(),cbxRank.getSelectedItem().toString(),
                        txtConstellation.getText(),power,txtMission.getText(),reward,difficulty);
                if(knightMissions.knightExist(sk.getId(),tableModel)){
                    JOptionPane.showMessageDialog(null, "El caballero ya existe");
                    boolean success=knightMissions.updateKnight(sk.getId(),sk,tableModel);
                    if(success){
                        JOptionPane.showMessageDialog(null, "se actualizo correctamente");
                        clearTextBox();
                    }else{
                        JOptionPane.showMessageDialog(null, "Ocurrio un error intenta nuevamente");
                        clearTextBox();
                    }

                }else{
                    sk.calculateSanctuaryFund(reward);
                    sk.calculateKingdomTaxes(reward);
                    knightMissions.add(sk,tableModel);
                    clearTextBox();
                }


            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=0;
                String reward,difficulty,power;
                try{
                    id=Integer.parseInt(txtUpdate.getText());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                if(knightMissions.knightExist(id,tableModel)){
                    SodiacKnight sk= knightMissions.findKnight(id, tableModel);
                    power=Integer.toString(sk.getPower());
                    reward=Double.toString(sk.getReward());
                    difficulty=Integer.toString(sk.getDifficulty());
                    txtName.setText(sk.getName());
                    cbxRank.setSelectedItem(sk.getRank());
                    txtConstellation.setText(sk.getConstellation());
                    txtMission.setText(sk.getMission());
                    txtReward.setText(reward);
                    cbxDifficulty.setSelectedItem(difficulty);
                    cbxPower.setSelectedItem(power);
                    JOptionPane.showMessageDialog(null,"Modifica los datos en la parte superior");

                }
            }
        });
    }
    private void clearTextBox(){
        txtReward.setText("");
        txtUpdate.setText("");
        txtMission.setText("");
        txtConstellation.setText("");
        txtName.setText("");
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("MissionsGUI");
        frame.setContentPane(new MissionsGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
