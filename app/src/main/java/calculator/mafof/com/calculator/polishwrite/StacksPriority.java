package calculator.mafof.com.calculator.polishwrite;

class StacksPriority {
    /**
     * Метод проверяющий 1 блок
     * @param in - приходящие данные со стека примера
     */
    protected boolean stackOneIn(String in) {
        return in.equals("BREAK") || in.equals("+") || in.equals("-");
    }

    /**
     * Метод проверяющий 1 блок
     * @param in - приходящие данные со стека `техас`
     */
    protected boolean stackOneOut(String in) {
        return in.equals("+") || in.equals("-") || in.equals("*") || in.equals("/");
    }

    /**
     * Метод проверяющий 2 блок
     * @param in - приходящие данные со стека примера
     */
    protected boolean stackTwoIn(String in) {
        return in.equals("*") || in.equals("/");
    }

    /**
     * Метод проверяющий 2 блок
     * @param in - приходящие данные со стека `техас`
     */
    protected boolean stackTwoOut(String in) {
        return in.equals("BREAK") || in.equals("+") || in.equals("-");
    }

    /**
     * Метод проверяющий 3 блок(общий)
     * @param in - приходящие данные со стека примера/`техас`
     */
    protected boolean stackThree(String in) {
        return in.equals("*") || in.equals("/");
    }

    /**
     * Метод проверяющий 4 блок
     * @param in - приходящие данные со стека примера
     */
    protected boolean stackFourIn(String in) { return in.equals("("); }

    /**
     * Метод проверяющий 4 блок
     * @param in - приходящие данные со стека `техас`
     */
    protected boolean stackFourOut(String in) {
        return in.equals("BREAK") || in.equals("+") || in.equals("-") || in.equals("*") || in.equals("/") || in.equals("(");
    }

    /**
     * Метод проверяющий 5 блок
     * @param in - приходящие данные со стека примера
     */
    protected boolean stackFiveIn(String in) { return in.equals(")"); }

    /**
     * Метод проверяющий 5 блок
     * @param in - приходящие данные со стека `техас`
     */
    protected boolean stackFiveOut(String in) {
        return in.equals("+") || in.equals("-") || in.equals("*") || in.equals("/");
    }

    /**
     * Метод проверяющий 6 блок
     * @param in - приходящие данные со стека примера
     */
    protected boolean stackSixIn(String in) {
        return in.equals("+") || in.equals("-") || in.equals("*") || in.equals("/");
    }

    /**
     * Метод проверяющий 6 блок
     * @param in - приходящие данные со стека `техас`
     */
    protected boolean stackSixOut(String in) { return in.equals("("); }

    /**
     * Метод проверяющий 7 блок
     * @param in - приходящие данные со стека примера
     */
    protected boolean stackSevenIn(String in) { return in.equals("+") || in.equals("-"); }

    /**
     * Метод проверяющий 7 блок
     * @param in - приходящие данные со стека `техас`
     */
    protected boolean stackSevenOut(String in) { return in.equals("BREAK"); }
}
