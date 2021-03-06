package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class CountingDownState implements StopwatchState {

    public CountingDownState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;


    @Override
    public void onClick() {
        sm.actionReset();
        sm.toStoppedState();
    }

    @Override
    public void onTick() {
        sm.actionDec();
        if (sm.getTime() == 0) {
            sm.toAlarmingState();
        }
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.COUNTING_DOWN;
    }
}