package net.sf.anathema.acceptance.fixture.character.template;

public class CheckHealthTemplateFixture extends AbstractTemplateColumnFixture {

  public String getToughnessControllingTrait() {
    return getTemplate().getToughnessControllingTraitType().getId();
  }
}