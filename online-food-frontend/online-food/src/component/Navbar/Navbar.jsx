import React from 'react';
import {Avatar, Badge, IconButton} from "@mui/material";
import SearchIcon from '@mui/icons-material/Search';
import {blue} from "@mui/material/colors";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import "./Navbar.css";

export const Navbar = () =>{
    return (
        <div className="px-5 z-50 py-[.8rem] bg-[#0032ee] lg:px-20 flex justify-between">
            <div className="cursor-pointer flex items-center space-x-4">
                <li className="logo font-semibold text-gray-300 text-2xl">
                    Online Food
                </li>
            </div>
            <div className="flex items-center space-x-2 lg:space-x-10">
                <div className="">
                    <IconButton>
                        <SearchIcon sx={{fontSize:"1.5rem"}}/>
                    </IconButton>
                </div>
                <div className="">
                    <Avatar sx={{bgcolor:"white", color: blue.A400}}></Avatar>
                </div>
                <div className="">
                    <IconButton>
                        <Badge color="primary" badgeContent={3}>
                            <ShoppingCartIcon sx={{fontSize:"1.5rem"}} />
                        </Badge>
                    </IconButton>
                </div>
            </div>
        </div>
    )
}