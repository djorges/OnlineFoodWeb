import React from "react"
import ShoppingBagIcon from "@mui/icons-material/ShoppingBag"
import HomeIcon from '@mui/icons-material/Home';
import FavoriteIcon from '@mui/icons-material/Favorite';
import AccountBalanceWalletIcon from '@mui/icons-material/AccountBalanceWallet';
import NotificationsActiveIcon from '@mui/icons-material/NotificationsActive';
import EventIcon from '@mui/icons-material/Event';
import LogoutIcon from '@mui/icons-material/Logout';
import AddReactionIcon from '@mui/icons-material/AddReaction';
import {Divider, Drawer, useMediaQuery} from "@mui/material";

const menu =[
    {title:"Orders", icon:<ShoppingBagIcon/>},
    {title:"Favorites", icon: <FavoriteIcon/>},
    {title:"Address", icon: <AddReactionIcon/>},
    {title:"Payments", icon: <AccountBalanceWalletIcon/>},
    {title:"Notification", icon: <NotificationsActiveIcon/>},
    {title:"Events", icon: <EventIcon/>},
    {title:"Logout", icon: <LogoutIcon/>},
]
export const ProfileNavigation = ({open, handleClose}) => {
    const isSmallScreen = useMediaQuery("(max-width:900px)")

    return (
        <div>
            <Drawer
                variant={isSmallScreen ? "temporary" : "permanent"}
                open={isSmallScreen ? open: true}
                onClose={handleClose}
                anchor="left"
                sx={{zIndex: -1, position: "sticky"}}>
                {/*Icons*/}
                <div className="w-[50vw] lg:w-[20vw] h-90vh flex flex-col justify-center text-xl pt-24 gap-8">
                    {menu.map((item,index)=>
                        <>
                            <div className="px-5 flex items-center space-x-5 cursor-pointer">
                                {item.icon}
                                <span>{item.title}</span>
                            </div>
                            {index !== menu.length - 1 && <Divider />}
                        </>
                    )}
                </div>
            </Drawer>
        </div>
    )
}