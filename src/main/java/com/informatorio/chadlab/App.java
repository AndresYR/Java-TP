package com.informatorio.chadlab;

import com.informatorio.chadlab.service.menu.MenuService;
import com.informatorio.chadlab.service.menu.impl.MenuServiceImpl;


public class    App
{
    public static void main( String[] args )
    {

        MenuService menuService = new MenuServiceImpl();
        menuService.seleccionar();
    }
}
