package net.sf.anathema.character.equipment.impl.character.model.stats.modification;

import net.sf.anathema.character.equipment.MagicalMaterial;
import net.sf.anathema.character.generic.impl.rules.ExaltedEdition;
import net.sf.anathema.character.generic.rules.IExaltedRuleSet;

public class AccuracyModification implements IStatsModification {

  private final MagicalMaterial material;
  private final IExaltedRuleSet ruleSet;

  public AccuracyModification(MagicalMaterial material, IExaltedRuleSet ruleSet) {
    this.material = material;
    this.ruleSet = ruleSet;
  }

  /* (non-Javadoc)
   * @see net.sf.anathema.character.equipment.impl.character.model.stats.modification.IStatsModification#getModifiedValue(int, net.sf.anathema.character.equipment.impl.character.model.stats.modification.WeaponStatsType)
   */
  public int getModifiedValue(int input, WeaponStatsType type) {
    boolean isSecondEdition = ruleSet.getEdition() == ExaltedEdition.SecondEdition;
    if (material == MagicalMaterial.Soulsteel && !type.isRanged()) {
      return isSecondEdition ? input + 2 : input + 1;
    }
    if (material == MagicalMaterial.Orichalcum) {
      return input + 1;
    }
    if (material == MagicalMaterial.Moonsilver) {
      return type.isRanged() ? input + 1 : input+ 2;
    }
    if (material == MagicalMaterial.Starmetal && isSecondEdition) {
      return input + 1;
    }
    return input;
  }
}