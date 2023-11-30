package Model;

import Model.Movable;

public interface Loadable extends Movable {
    int getSize();
    void setActive();
    void setInactive();
}
