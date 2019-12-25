import java.util.ArrayList;

public class State {
    public int mLeft;
    public int cLeft;
    public int bLeft;
    public State(int mLeft, int cLeft,int bLeft){
        this.mLeft = mLeft;
        this.cLeft = cLeft;
        this.bLeft = bLeft;
    }
    public boolean isGoal(){
        if(mLeft == 0 && cLeft ==0 && bLeft ==0){
            return true;
        }
        return false;
    }
    public boolean isValid(){
        if(mLeft>3 || cLeft>3){
            return false;
        }
        if(mLeft>=0 && cLeft>=0 && (mLeft==0||mLeft>=cLeft)&&(3-mLeft==0 || 3-mLeft>=3-cLeft)){
            return true;
        }
        return false;
    }
    private void testandadd(ArrayList<State> succ, State state){
        if (state.isValid()) {
            succ.add(state);
        }
    }
    public ArrayList<State> successors(){
        //generate successors of state i with different operations
        ArrayList<State> succ = new ArrayList<>();
        if(bLeft==1){
            testandadd(succ,new State(mLeft-1,cLeft,0));
            testandadd(succ,new State(mLeft,cLeft-1,0));
            testandadd(succ,new State(mLeft-1,cLeft-1,0));
            testandadd(succ,new State(mLeft-2,cLeft,0));
            testandadd(succ,new State(mLeft,cLeft-2,0));
        } else{
            testandadd(succ,new State(mLeft+1,cLeft,1));
            testandadd(succ,new State(mLeft,cLeft+1,1));
            testandadd(succ,new State(mLeft+1,cLeft+1,1));
            testandadd(succ,new State(mLeft+2,cLeft,1));
            testandadd(succ,new State(mLeft,cLeft+2,1));
        }
        return succ;
    }
    //Override hash method to insure Hashset work
    @Override
    public int hashCode(){
        return this.mLeft*100+this.cLeft*10+this.bLeft;
    }
    @Override
    public boolean equals(Object obj){
        State state = (State) obj;
        if (this.bLeft == state.bLeft && this.mLeft == state.mLeft && this.cLeft == state.cLeft){
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("m:"+this.mLeft+"\tc:"+this.cLeft+"\tb:"+this.bLeft);
        return sb.toString();
    }
}
