package com.twu;


//@RunWith(MockitoJUnitRunner.class)
public class BibliotecaAppTest {
//    @Mock
//    ConsoleOut consoleOut;
//    @Mock
//    BookSearcher bookSearcher;
//    @Mock
//    Library library;
//    @Mock
//    MenuView customerMenuView;
//    @Mock
//    MenuView librarianMenuView;
//    @Mock
//    LoginController loginController;
//    @Mock
//    Customer customer;
//    @Mock
//    LogoutAction logoutAction;
//    @Mock
//    LibrarianController librarianController;
//    @Mock
//    CustomerController customerController;
//
//    private BibliotecaApp bibliotecaApp;
//    private QuitAction quitAction;
//    private Customer customerOne;
//
//    @Before
//    public void setUp() throws Exception {
//        quitAction = new QuitAction();
//        HashSet<AbstractUser> allUsers = new HashSet<>();
//        customerOne = new Customer("123-4567", "Password", "Name1", "Email1", "Phone1");
//        Customer customerTwo = new Customer("111-1111", "11111", "Name2", "Email2", "Phone2");
//        allUsers.add(customerOne);
//        allUsers.add(customerTwo);
//        when(loginController.login()).thenReturn(customerOne);
//        when(librarianController.execute(customerOne)).thenReturn(quitAction);
//        when(customerController.execute(customerOne)).thenReturn(quitAction);
//        bibliotecaApp = new BibliotecaApp(consoleOut, quitAction, loginController, librarianController, customerController, null);
//    }
//
//    @Test
//    public void shouldPrintWelcomeMessage() throws Exception {
//        bibliotecaApp.start();
//
//        Mockito.verify(consoleOut).printWelcomeMessage();
//    }
//
//    @Test
//    public void shouldGetOutOfLoopUponQuitSelection() throws Exception {
//        bibliotecaApp.start();
//
//        verify(customerController, times(1)).execute(customerOne);
//    }
//
//    @Test
//    public void shouldGetOutOfLoopUponLogoutSelection() throws Exception {
//        customerMenuView = mock(MenuView.class);
//        LogoutAction logoutAction = new LogoutAction();
//        bibliotecaApp = new BibliotecaApp(consoleOut,
//                quitAction, loginController, librarianController, customerController, );
//        when(librarianController.execute(customerOne)).thenReturn(quitAction)
//                .thenReturn(logoutAction)
//                .thenReturn(new QuitAction());
//        bibliotecaApp.start();
//
//        verify(customerController, times(1)).execute(customerOne);
//    }
}