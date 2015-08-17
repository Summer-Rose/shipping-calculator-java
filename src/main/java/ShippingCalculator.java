public class ShippingCalculator {
  private int mLength;
  private int mWidth;
  private int mHeight;
  private int mVolume;
  private int mSpeed;
  private int mDistance;

  public ShippingCalculator(int length, int width, int height) {
    mLength = length;
    mWidth = width;
    mHeight = height;
    mVolume = length * width * height;
  }

  public int getLength() {
    return mLength;
  }
  public int getWidth() {
    return mWidth;
  }
  public int getHeight() {
    return mHeight;
  }
  public int getVolume() {
    return mVolume;
  }

  public int getCost(int speed, int distance) {
    return (mVolume * speed * distance)/1000;
  }
}
