package net.sf.anathema.characterengine.persona;

import net.sf.anathema.characterengine.quality.QualityKey;
import net.sf.anathema.characterengine.quality.QualityListener;
import net.sf.anathema.characterengine.quality.Type;

public interface Qualities {

  void addQuality(QualityKey qualityKey);

  void doFor(QualityKey qualityKey, QualityClosure closure);

  void doForEach(Type type, QualityClosure closure);

  void observe(QualityKey key, QualityListener listener);

  void stopObservation(QualityKey key, QualityListener listener);
}