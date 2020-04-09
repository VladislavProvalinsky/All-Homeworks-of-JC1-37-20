package test.RobotGenerics;


public class Robot <T extends Head> {

    private Body body;
    private T head;

//    public <T1, T2 extends Head> T1 foo (T1 a, T2 b){
//        return a;
//    }

    public static String getAll(Robot <? extends Head> robot){
        String str ="";
        str +=robot.getHead();
        return str;
    }

    public Robot(Body body, T head){
        this.body = body;
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public T getHead() {
        return head;
    }
}

class Test{
    public static void main(String[] args) {
        Robot<SmallHead> robot = new Robot<>(new Body(),new SmallHead());
        robot.getHead().cool();
        Robot<BigHead> robot1 = new Robot<>(new Body(), new BigHead());
        robot1.getHead().burn();
        Robot<SmallHead> robot2 = new Robot<>(new Body(), new SmallHead());

        Robot.getAll(robot1);

    }
}
