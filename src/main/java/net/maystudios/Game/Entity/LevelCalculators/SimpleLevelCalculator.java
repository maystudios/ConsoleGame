package net.maystudios.Game.Entity.LevelCalculators;

import net.maystudios.Game.Entity.LevelCalculator;

public class SimpleLevelCalculator implements LevelCalculator {
        @Override
        public int calculateNewStat(int stat, int level) {
            return stat + (int) (stat * (level * 0.1));
        }
}
