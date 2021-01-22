package core.spi.impl;

import com.core.ObjectModel;

public class SingleObjectModel extends ObjectModel {

    private Object object;

    public SingleObjectModel(String id, Object object) {
        super(id);
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "SingleObjectModel{" +
                "object=" + object +
                "id=" + getId() +
                '}';
    }
}
