package view;

import entitys.entity;

public interface Dialog {

    public void setVisible(boolean b);
    public void dispose();

    public void setEditable(boolean b);
    public void setData(entity entity);
    public void clear();
    public entity getEntity();

    default void showEntity(entity entity,boolean b) {
        if(entity == null){
            this.clear();
        }
        else{
            this.setData(entity);
            this.setEditable(b);
            setVisible(true);
        }
    }
}
