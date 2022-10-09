package WishTea;


public class WishTea{
    private String name;
    private char size;
    private int ice_level;
    private int topping;
    private int amount;

    public WishTea(String _name, char _size, int _iceLevel, int _topping, int _amount){
        this.name = _name;
        this.size = _size;
        this.ice_level = _iceLevel;
        this.topping = _topping;
        this.amount = _amount;

        calcCost();
    }

    public int getAmount(){
        return this.amount;
    }

    public double calcCost(){
        double tax = 0.05;
        double cost = 0;

        switch(name){
            case "Green tea":
                switch(size){
                    case 'S':
                        cost = 60;
                        break;
                    case 'M':
                        cost = 70;
                        break;
                    case 'L':
                        cost = 80;
                        break;
                }
                cost += 5*topping;
                cost *= amount;
                break;
            case "Black tea":
                switch(size){
                    case 'S':
                        cost = 55;
                        break;
                    case 'M':
                        cost = 65;
                        break;
                    case 'L':
                        cost = 75;
                        break;
                }
                cost += 5*topping;
                cost *= amount;
                break;
            case "Lemon tea":
                switch(size){
                    case 'S':
                        cost = 65;
                        break;
                    case 'M':
                        cost = 80;
                        break;
                    case 'L':
                        cost = 95;
                        break;
                }
                cost += 10*topping;
                cost *= amount;
                break;
        }

        cost += cost*tax;
        return cost;
    }

    public String getDescription(){
        String topping = (this.topping == 0) ? "No topping" : "topping   ";
        String val = this.name + "   " + this.size + "   " + topping + "   " + "   " + this.amount + "        $" + Math.round(this.calcCost());

        return val;
    }
}