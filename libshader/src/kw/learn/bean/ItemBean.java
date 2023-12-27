package kw.learn.bean;

/**
 * @Auther jian xian si qi
 * @Date 2023/12/27 15:44
 */
public class ItemBean {
    private int index;
    private String name;
    public ItemBean(String name,int index){
        this.name = name;
        this.index = index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
