package net.sf.anathema.character.equipment.impl.reporting.first.weaponstats;

import net.sf.anathema.character.equipment.impl.reporting.AbstractSpeedWeaponStatsGroup;
import net.sf.anathema.character.generic.character.IGenericTraitCollection;
import net.sf.anathema.character.generic.equipment.weapon.IWeaponStats;
import net.sf.anathema.character.generic.traits.types.AttributeType;
import net.sf.anathema.lib.resources.IResources;

public class FirstEditionSpeedWeaponStatsGroup extends AbstractSpeedWeaponStatsGroup {

  private final IGenericTraitCollection collection;

  public FirstEditionSpeedWeaponStatsGroup(IResources resources, IGenericTraitCollection collection) {
    super(resources);
    this.collection = collection;
  }

  @Override
  protected int getSpeedValue(IWeaponStats weapon) {
    return collection.getTrait(AttributeType.Dexterity).getCurrentValue()
        + collection.getTrait(AttributeType.Wits).getCurrentValue()
        + weapon.getSpeed();
  }
}