package com.koobin.enumerate;

/**
 * @author gutaegyun
 */
public enum Planet {
  // Java에서는 필드나 메소드보다 먼저 상수를 정의해야 합니다.
  MERCURY(3.303e+23, 2.4397e6),
  VENUS(4.869e+24, 6.0518e6),
  EARTH(5.976e+24, 6.37814e6),
  MARS(6.421e+23, 3.3972e6),
  JUPITER(1.9e+27, 7.1492e7),
  SATURN(5.688e+26, 6.0268e7),
  URANUS(8.686e+25, 2.5559e7),
  // 필드와 메서드가 있는 경우 열거형 상수 목록은 세미콜론으로 끝나야 합니다.
  NEPTUNE(1.024e+26, 2.4746e7);

  private final double mass;   // in kilograms
  private final double radius; // in meters


  Planet(double mass, double radius) {
    this.mass = mass;
    this.radius = radius;
  }

  private double mass() {
    return mass;
  }

  private double radius() {
    return radius;
  }

  // universal gravitational constant  (m3 kg-1 s-2)
  public static final double G = 6.67300E-11;

  double surfaceGravity() {
    return G * mass / (radius * radius);
  }

  double surfaceWeight(double otherMass) {
    return otherMass * surfaceGravity();
  }

  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Usage: java Planet <earth_weight>");
      System.exit(-1);
    }
    double earthWeight = Double.parseDouble(args[0]);
    double mass = earthWeight / EARTH.surfaceGravity();
    // 컴파일러는 enum을 만들 때 몇 가지 특수 메서드를 자동으로 추가합니다.

    for (Planet p : Planet.values()) {
      System.out.printf("Your weight on %s is %f%n",
          p, p.surfaceWeight(mass));
    }
  }
}