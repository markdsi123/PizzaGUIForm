import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PizzaGUIFrame extends JFrame {
    JPanel topPnl;
    JPanel crustPnl;
    JPanel toppingPnl;
    JPanel sizePnl;
    JPanel orderPnl;
    JPanel bottomPnl;
    JPanel mainPnl;
    JTextArea orderTA;
    JScrollPane scroller;
    JRadioButton thin;
    JRadioButton regular;
    JRadioButton deepDish;
    JButton btnOrder;
    JButton btnClear;
    JButton btnQuit;
    JComboBox sizeBox;
    JCheckBox[] toppingCB;
    StringBuilder receipt;

    public PizzaGUIFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPanel();
        createOrderPanel();
        createBottomPanel();

        mainPnl.add(topPnl, BorderLayout.NORTH);
        mainPnl.add(orderPnl, BorderLayout.CENTER);
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);
        pack();
    }

    private void createTopPanel() {
        topPnl = new JPanel();

        crustPnl = createTitledPanel("Crust Type");
        thin = new JRadioButton("Thin");
        regular = new JRadioButton("Regular");
        deepDish = new JRadioButton("Deep-dish");

        //Grouping buttons
        ButtonGroup crustGroup = new ButtonGroup();
        crustGroup.add(thin);
        crustGroup.add(regular);
        crustGroup.add(deepDish);

        //Adding crustType to its panel
        crustPnl.add(thin);
        crustPnl.add(regular);
        crustPnl.add(deepDish);

        //Making size panel which is in top panel as well
        sizePnl = createTitledPanel("Size");
        String[] sizes = {"Small","Medium", "Large", "Super"};
        sizeBox = new JComboBox<>(sizes);
        sizePnl.add(sizeBox);

        //Topping panel
        toppingPnl = new JPanel();
        toppingPnl.setLayout(new GridLayout(3,2));
        toppingPnl.setBorder(BorderFactory.createTitledBorder("Toppings"));
        String[] toppings = {"Fries","Lettuce","Chicken","Pineapple","Onion","Cheese"};
        toppingCB = new JCheckBox[toppings.length];

        for(int i=0;i<toppings.length;i++)
        {
            toppingCB[i] = new JCheckBox(toppings[i]);
            toppingPnl.add(toppingCB[i]);
        }

        topPnl.add(crustPnl);
        topPnl.add(sizePnl);
        topPnl.add(toppingPnl);
    }

    private void createOrderPanel() {
        orderPnl = createTitledPanel("Order Summary");
        orderTA = new JTextArea(20,30);
        orderTA.setEditable(false);
        scroller = new JScrollPane(orderTA);
        orderPnl.add(scroller);
    }

    private void createBottomPanel() {
        bottomPnl = new JPanel();

        btnOrder = new JButton("Order");
        btnOrder.setFont(new Font("Serif", Font.PLAIN, 14));
        btnOrder.addActionListener(e -> {
            placeOrder();
        });
        btnClear = new JButton("Clear");
        btnClear.setFont(new Font("Serif", Font.PLAIN, 14));
        btnClear.addActionListener(e -> {
            clearOrder(sizeBox,toppingCB, orderTA);
        });

        btnQuit = new JButton("Quit");
        btnQuit.setFont(new Font("Serif", Font.PLAIN, 14));
        btnQuit.addActionListener(e -> {
            System.exit(0);
        });

        bottomPnl.add(btnOrder);
        bottomPnl.add(btnClear);
        bottomPnl.add(btnQuit);

    }

    private static JPanel createTitledPanel(String title) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }
    private void placeOrder()
    {
        //Declaring these variables to make its value reset every single time we order
        double baseCost = 0;
        double ingCost =0;
        double totalCost;
        double tax;
        double subTotal;

        receipt = new StringBuilder();
        receipt.append("==========================\n");
        if(thin.isSelected())
        {
            receipt.append("Thin & " + sizeBox.getSelectedItem());
            if(sizeBox.getSelectedItem() == "Small")
            {
                baseCost = 8.00;
                receipt.append("\t\t$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
            else if(sizeBox.getSelectedItem() == "Medium")
            {
                baseCost = 12;
                receipt.append("\t\t$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
            else if(sizeBox.getSelectedItem() == "Large")
            {
                baseCost = 16;
                receipt.append("\t\t$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
            else
            {
                baseCost = 20;
                receipt.append("\t\t$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
        }
        else if(deepDish.isSelected())
        {
            receipt.append("Deep-dish & " + sizeBox.getSelectedItem());
            if(sizeBox.getSelectedItem() == "Small")
            {
                baseCost = 8.00;
                receipt.append("\t$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
            else if(sizeBox.getSelectedItem() == "Medium")
            {
                baseCost = 12;
                receipt.append("\t$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
            else if(sizeBox.getSelectedItem() == "Large")
            {
                baseCost = 16;
                receipt.append("\t$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
            else
            {
                baseCost = 20;
                receipt.append("\t$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
        }
        else
        {
            receipt.append("Regular & " + sizeBox.getSelectedItem());
            if(sizeBox.getSelectedItem() == "Small")
            {
                baseCost = 8.00;
                receipt.append("\t" + "$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
            else if(sizeBox.getSelectedItem() == "Medium")
            {
                baseCost = 12;
                receipt.append("\t$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
            else if(sizeBox.getSelectedItem() == "Large")
            {
                baseCost = 16;
                receipt.append("\t$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
            else
            {
                baseCost = 20;
                receipt.append("\t$" + baseCost);
                for (JCheckBox checkedBox : toppingCB)
                {
                    if(checkedBox.isSelected())
                    {
                        ingCost+=1;
                    }
                }
                receipt.append("\nIngredients\t\t$" + ingCost);
                subTotal=baseCost+ingCost;
                receipt.append("\n\nSub-total:\t\t$" + subTotal);
                tax = 0.07*subTotal;
                receipt.append("\n\nTax:\t\t$" + String.format("%.2f",tax));
                receipt.append("\n-------------------------");
                totalCost=subTotal+tax;
                receipt.append("\n\nTotal:\t\t$" + totalCost);
            }
        }
        orderTA.setText(String.valueOf(receipt));
    }
    private void clearOrder(JComboBox<String> sizeComboBox, JCheckBox[] toppingCheckboxes, JTextArea orderTA) {

        sizeComboBox.setSelectedIndex(0);
        for (JCheckBox checkbox : toppingCheckboxes) {
            checkbox.setSelected(false);
        }
        regular.setSelected(true);
        orderTA.setText("");
    }
}