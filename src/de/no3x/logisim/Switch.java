package de.no3x.logisim;

import com.cburch.logisim.data.Value;
import com.cburch.logisim.instance.InstanceDataSingleton;
import com.cburch.logisim.instance.InstancePoker;
import com.cburch.logisim.instance.InstanceState;
import com.cburch.logisim.std.io.Button;

import java.awt.event.MouseEvent;

/**
 * Created by No3x on 17.05.15.
 */
public class Switch extends Button {
    public Switch() {
        super();
        this.setInstancePoker(Switch.Poker.class);
    }

    @Override
    public String getName() {
        return "Schalter";
    }

    @Override
    public String getDisplayName() {
        return "Schalter";
    }

    public static class Poker extends InstancePoker {
        public Poker() {
        }

        public void mousePressed(InstanceState state, MouseEvent e) {
            this.setValue(state, Value.TRUE);
        }

        private void setValue(InstanceState state, Value val) {
            InstanceDataSingleton data = (InstanceDataSingleton) state.getData();
            if (data == null) {
                state.setData(new InstanceDataSingleton(val));
            } else {
                val = this.switchButtonValue((Value) data.getValue());
                data.setValue(val);
            }

            state.getInstance().fireInvalidated();
        }

        private Value switchButtonValue(Value val) {
            return val.equals(Value.FALSE) ? Value.TRUE : Value.FALSE;
        }
    }
}
