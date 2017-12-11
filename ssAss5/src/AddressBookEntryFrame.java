// Fig. 8.37: AddressBookEntryFrame.java
// A subclass of JInternalFrame customized to display and
// an AddressBookEntry or set an AddressBookEntry's properties
// based on the current data in the UI.

// Java core packages
import java.util.*;
import java.awt.*;
// Java extension packages
import javax.swing.*;

public class AddressBookEntryFrame extends JInternalFrame {

    // HashMap to store JTextField references for quick access
    private HashMap fields;

    // current AddressBookEntry set by AddressBook application
    private AddressBookEntry person;

    // panels to organize GUI
    private JPanel leftPanel, rightPanel;

    // static integers used to determine new window positions
    // for cascading windows
    private static int xOffset = 0, yOffset = 0;

    // static Strings that represent name of each text field.
    // These are placed on JLabels and used as keys in
    // HashMap fields.
    private static final String FIRST_NAME = "First Name", LAST_NAME = "Last Name",
            ADDRESS1 = "Address 1", ADDRESS2 = "Address 2",
            COUNTY = "County", EIRCODE = "Eircode", PHONE = "Phone", EMAIL = "Email",
            EXTRA_ADDRESS1 = "Alternative Address 1", EXTRA_ADDRESS2 = "Alternative Address 2",
            EXTRA_COUNTY = "Alternative County", EXTRA_EIRCODE = "Alternative Eircode", EXTRA_PHONE = "Alternative Phone",
            EXTRA_EMAIL = "Alternative Email";

    // construct GUI
    public AddressBookEntryFrame()
    {
        super( "Address Book Entry", true, true );

        fields = new HashMap();

        leftPanel = new JPanel();
        leftPanel.setLayout( new GridLayout( 14, 1, 0, 5 ) );
        rightPanel = new JPanel();
        rightPanel.setLayout( new GridLayout( 14, 1, 0, 5 ) );

        createRow( FIRST_NAME );
        createRow( LAST_NAME );
        createRow( ADDRESS1 );
        createRow( ADDRESS2 );
        createRow( COUNTY );
        createRow( EIRCODE );
        createRow( EXTRA_ADDRESS1 );
        createRow( EXTRA_ADDRESS2 );
        createRow( EXTRA_COUNTY );
        createRow( EXTRA_EIRCODE );
        createRow( PHONE );
        createRow( EXTRA_PHONE );
        createRow( EMAIL );
        createRow( EXTRA_EMAIL );

        Container container = getContentPane();
        container.add( leftPanel, BorderLayout.WEST );
        container.add( rightPanel, BorderLayout.CENTER );

        setBounds( xOffset, yOffset, 300, 300 );
        xOffset = ( xOffset + 30 ) % 300;
        yOffset = ( yOffset + 30 ) % 300;
    }

    // set AddressBookEntry then use its properties to
    // place data in each JTextField
    public void setAddressBookEntry( AddressBookEntry entry )
    {
        person = entry;

        setField( FIRST_NAME, person.getFirstName() );
        setField( LAST_NAME, person.getLastName() );

        setField( ADDRESS1, person.getAddress1() );
        setField( ADDRESS2, person.getAddress2() );
        setField( COUNTY, person.getCounty() );
        setField( EIRCODE, person.getEircode() );
        setField( PHONE, person.getPhoneNumber() );
        setField( EMAIL, person.getEmailAddress() );

        setField( EXTRA_ADDRESS1, person.getExtraAddress1() );
        setField( EXTRA_ADDRESS2, person.getExtraAddress2() );
        setField( EXTRA_COUNTY, person.getExtraCounty() );
        setField( EXTRA_EIRCODE, person.getExtraEircode() );
        setField( EXTRA_PHONE, person.getExtraPhoneNumber() );
        setField( EXTRA_EMAIL, person.getExtraEmailAddress() );
    }

    // store AddressBookEntry data from GUI and return
    // AddressBookEntry
    public AddressBookEntry getAddressBookEntry()
    {
        person.setFirstName( getField( FIRST_NAME ) );
        person.setLastName( getField( LAST_NAME ) );
        person.setAddress1( getField( ADDRESS1 ) );
        person.setAddress2( getField( ADDRESS2 ) );
        person.setCounty(getField( COUNTY ));
        person.setEircode(getField( EIRCODE ));
        person.setPhoneNumber( getField( PHONE ) );
        person.setEmailAddress( getField( EMAIL ) );
        person.setExtraAddress1(getField(EXTRA_ADDRESS1));
        person.setExtraAddress2(getField(EXTRA_ADDRESS2));
        person.setExtraCounty(getField(EXTRA_COUNTY));
        person.setExtraEircode(getField(EXTRA_EIRCODE));
        person.setExtraPhoneNumber(getField(EXTRA_PHONE));
        person.setExtraEmailAddress( getField( EXTRA_EMAIL ) );

        return person;
    }

    // set text in JTextField by specifying field's
    // name and value
    private void setField( String fieldName, String value )
    {
        JTextField field =
                ( JTextField ) fields.get( fieldName );

        field.setText( value );
    }

    // get text in JTextField by specifying field's name
    private String getField( String fieldName )
    {
        JTextField field =
                ( JTextField ) fields.get( fieldName );

        return field.getText();
    }

    // utility method used by constructor to create one row in
    // GUI containing JLabel and JTextField
    private void createRow( String name )
    {
        JLabel label = new JLabel( name, SwingConstants.RIGHT );
        label.setBorder(
                BorderFactory.createEmptyBorder( 5, 5, 5, 5 ) );
        leftPanel.add( label );

        JTextField field = new JTextField( 30 );
        rightPanel.add( field );

        fields.put( name, field );
    }
}  // end class AddressBookEntryFrame


/**************************************************************************
 * (C) Copyright 2001 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/