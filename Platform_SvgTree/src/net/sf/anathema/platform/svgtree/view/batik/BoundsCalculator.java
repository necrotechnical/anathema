package net.sf.anathema.platform.svgtree.view.batik;

import org.apache.batik.bridge.SVGGElementBridge;
import org.apache.batik.dom.svg.SVGContext;
import org.apache.batik.dom.svg.SVGOMGElement;
import org.w3c.dom.svg.SVGLocatable;
import org.w3c.dom.svg.SVGMatrix;
import org.w3c.dom.svg.SVGRect;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public class BoundsCalculator implements IBoundsCalculator {
  
  private SVGContext savedContext;

  @Override
  public Rectangle getBounds(SVGLocatable svgElement) {
    //below block to protect against exceptions related to special display components
    boolean useStoredContext = false;
    if (svgElement instanceof SVGOMGElement) {
      SVGOMGElement element = (SVGOMGElement) svgElement;
      if (element.getSVGContext() == null && savedContext != null) {
        element.setSVGContext(savedContext);
        useStoredContext = true;
      } else {
        savedContext = savedContext == null
                    && element.getSVGContext() instanceof SVGGElementBridge
                     ? element.getSVGContext() : savedContext;
      }
    }
    
    SVGMatrix screenCTM = svgElement.getScreenCTM();
    SVGRect bBox = svgElement.getBBox();
    AffineTransform paintingTransform = new AffineTransform(
        screenCTM.getA(),
        screenCTM.getB(),
        screenCTM.getC(),
        screenCTM.getD(),
        screenCTM.getE(),
        screenCTM.getF());
    Point2D startPoint = paintingTransform.transform(new Point2D.Float(bBox.getX(), bBox.getY()), null);
    float endX = bBox.getX() + bBox.getWidth();
    float endY = bBox.getY() + bBox.getHeight();
    Point2D endPoint = paintingTransform.transform(new Point2D.Float(endX, endY), null);
    Rectangle boundingRectangle = new Rectangle(
        (int) startPoint.getX(),
        (int) startPoint.getY(),
        (int) (endPoint.getX() - startPoint.getX()),
        (int) (endPoint.getY() - startPoint.getY()));
    
    if (useStoredContext) {
      ((SVGOMGElement)svgElement).setSVGContext(null);
    }
    
    return boundingRectangle;
  }
}