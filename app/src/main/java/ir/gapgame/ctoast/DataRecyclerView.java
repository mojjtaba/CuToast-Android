package ir.gapgame.ctoast;

public class DataRecyclerView {

    String title;
    String description;
    int color;
    int res;

    public DataRecyclerView(){

    }
    public DataRecyclerView(String title, String description,int color,int res){
        this.title=title;
        this.description=description;
        this.color=color;
        this.res=res;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
