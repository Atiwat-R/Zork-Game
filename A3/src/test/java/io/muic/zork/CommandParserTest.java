package io.muic.zork;


class CommandParserTest {
    // 1:10:00

    public static void main(String[] args) {
        CommandParser parser = new CommandParser();
        parser.parse("exit ar;l");

//        System.out.println("hall uai oki".substring("hall".length()).trim());

        String[] cmd = "   attack with Soulflayer ".trim().split(" ");

        for (String i : cmd) {
            System.out.println(">" + i + "<");
        }
    }


}