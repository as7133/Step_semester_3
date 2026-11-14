package AbstractionClassVSInterface.class_problems;

    import java.util.*;

    abstract class Plot {
        String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract double getArea();

        abstract String getShape();
    }

    class Circle extends Plot {
        double radius;

        Circle(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        double getArea() {
            return Math.PI * radius * radius;
        }

        String getShape() {
            return "CIRCLE";
        }
    }

    class Rectangle extends Plot {
        double length, width;

        Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        double getArea() {
            return length * width;
        }

        String getShape() {
            return "RECTANGLE";
        }
    }

    class Triangle extends Plot {
        double base, height;

        Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        double getArea() {
            return 0.5 * base * height;
        }

        String getShape() {
            return "TRIANGLE";
        }
    }

    public class GardenPlotAreaReport {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            List<Plot> plots = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String shape = sc.next();

                if (shape.equals("CIRCLE")) {
                    String owner = sc.next();
                    double radius = sc.nextDouble();
                    plots.add(new Circle(owner, radius));
                }
                else if (shape.equals("RECTANGLE")) {
                    String owner = sc.next();
                    double length = sc.nextDouble();
                    double width = sc.nextDouble();
                    plots.add(new Rectangle(owner, length, width));
                }
                else if (shape.equals("TRIANGLE")) {
                    String owner = sc.next();
                    double base = sc.nextDouble();
                    double height = sc.nextDouble();
                    plots.add(new Triangle(owner, base, height));
                }
            }

            double totalArea = 0;

            for (Plot p : plots) {
                double area = p.getArea();
                totalArea += area;
                System.out.printf("%s (%s): %.2f%n",
                        p.owner, p.getShape(), area);
            }

            System.out.printf("Total Area: %.2f%n", totalArea);

            sc.close();
        }
    }

