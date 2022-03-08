package es.ftoribio.dam.players;


import es.ftoribio.dam.models.Resource;

public abstract class Player {
    private int wood =0;
    private int carbon =0;
    private int wheat =0;



    public boolean allPlusTwenty(){
        return (this.wood >=20 && this.carbon>=20 && this.wheat >=20);
    }



    public void addValorNumero(Resource resource){
        if(resource == Resource.CARBON){
            carbon ++;
        }else if(resource == Resource.WHEAT){
            wheat++;
        }else if(resource == Resource.WOOD){
            wood++;
        }
    }


    public int getWood() {return wood;}

    public void setWood(int wood) {this.wood = wood;}

    public int getCarbon() {return carbon;}

    public void setCarbon(int carbon) {this.carbon = carbon;}

    public int getWheat() {return wheat;}

    public void setWheat(int wheat) {this.wheat = wheat;}


}
