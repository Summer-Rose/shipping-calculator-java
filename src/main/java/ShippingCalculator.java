public class ShippingCalculator {
  private int mLength;
  private int mWidth;
  private int mHeight;
  private int mVolume;
  private int mSpeed;
  private int mDistance;
  private int mTotalCost;
  private int mSurfaceArea;

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
    mTotalCost = (mVolume * speed * distance)/1000;
    return mTotalCost;
  }

  public int getSurfaceArea() {
    mSurfaceArea = ((2 * mLength * mHeight) + (2 * mHeight * mWidth) + (2 * mLength * mWidth));
    return mSurfaceArea;
  }

  public int getGiftWrapCost() {
    // return mSurfaceArea;
    if (mSurfaceArea > 25) {
      return mTotalCost + 5;
    } else if (mSurfaceArea >= 10) {
      return mTotalCost + 3;
    } else {
      return mTotalCost + 2;
    }
  }
}
