package Lists;

import Interfaces.Knight;

public class SodiacKnight implements Knight {
    private static int counterId = 1;
    private int id;
    private String name;
    private String rank;
    private String constellation;
    private int power;
    private String mission;
    private double reward;
    private double SanctuaryFund;
    private double kingdomTaxes;
    private int difficulty;

    public SodiacKnight(String name, String rank, String constellation, int power, String mission, double reward, int difficulty) {
        counterId++;
        this.id = counterId;
        this.name = name;
        this.rank = rank;
        this.constellation = constellation;
        this.power = power;
        this.mission = mission;
        this.reward = reward;
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getId() {
        return id;
    }

    public int setId(int id) {
        return this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRank() {
        return rank;
    }

    @Override
    public double calculateSanctuaryFund(double reward){
        if(reward==0){
            return 0;
        }
        double fund= reward*0.10;
        setReward(this.getReward()+(reward-fund));
        setSanctuaryFund(fund);
        return fund;
    }

    @Override
    public double calculateKingdomTaxes(double reward){
        if(reward==0){
            return 0;
        }
        double taxes=0;
        if(reward>100 && reward<=200){
            taxes= reward*0.12;
            setKingdomTaxes(taxes);
        }else if(reward>200 && reward<=400){
            taxes= reward*0.25;
            setKingdomTaxes(taxes);
        }else if(reward>400){
            taxes= reward*0.35;
            setKingdomTaxes(taxes);
        }
        setReward(this.getReward()+(reward-taxes));
        return taxes;
    }

    @Override
    public String toString() {
        StringBuilder knight = new StringBuilder();
        knight.append("Nombre del Caballero: ")
                .append(this.getName())
                .append("\n")
                .append("Rango: ")
                .append(this.getRank())
                .append("\n")
                .append("Constelacion: ")
                .append(this.getConstellation())
                .append("\n")
                .append("Nivel de Poder: ")
                .append(this.getPower())
                .append("\n")
                .append("Mision: ")
                .append(this.getMission())
                .append("\n")
                .append("Dificultad")
                .append(this.getDifficulty())
                .append("\n")
                .append("Aporte al Santuario: ")
                .append(this.getSanctuaryFund())
                .append("\n")
                .append("Impuestos del reino: ")
                .append(this.getKingdomTaxes())
                .append("\n")
                .append("Recompensa neta a recibir: ")
                .append(this.getReward());
        return knight.toString();
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public double getSanctuaryFund() {
        return SanctuaryFund;
    }

    private void setSanctuaryFund(double taxesDiscount) {
        this.SanctuaryFund = taxesDiscount;
    }

    public double getKingdomTaxes() {
        return kingdomTaxes;
    }

    private void setKingdomTaxes(double kingdomTaxes) {
        this.kingdomTaxes = kingdomTaxes;
    }
}
