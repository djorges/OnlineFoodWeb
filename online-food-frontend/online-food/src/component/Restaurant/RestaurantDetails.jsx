import React from 'react';
import {Divider, Grid} from "@mui/material";
import LocationOnIcon from '@mui/icons-material/LocationOn';
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';

const RestaurantDetails = () =>{
    return(
        <div className="px-5 lg:px-20">
            <section>
                <h3 className="text-gray-500 py-2">Home/usa/american fast food/3</h3>
                <div>
                    <Grid container spacing={2}>
                        <Grid item xs={12}>
                            <img
                                className="w-full h-[40vh] object-cover"
                                src="./restaurants/American fast food restaurant.jpg"
                                alt=""/>
                        </Grid>
                        <Grid item xs={12} lg={6}>
                            <img
                                className="w-full h-[40vh] object-cover"
                                src="./restaurants/American fast food restaurant.jpg"
                                alt=""/>
                        </Grid>
                        <Grid item xs={12} lg={6}>
                            <img
                                className="w-full h-[40vh] object-cover"
                                src="./restaurants/American fast food restaurant.jpg"
                                alt=""/>
                        </Grid>
                    </Grid>
                </div>
                <div className="pt-3 pb-5 text-left">
                    <h1 className="text-4xl font-semibold">American Fast Food</h1>
                    <p className="text-gray-500 mt-1">
                       Loren ipsum dolor sit amet consectetur adipisicing elit.
                    </p>
                    <div className="space-y-3 mt-3">
                        <p className="text-gray-500 flex items-center gap-3">
                            <LocationOnIcon />
                            <span>
                            Los Gatos, California
                        </span>
                        </p>
                        <p className="text-gray-500 flex items-center gap-3">
                            <CalendarMonthIcon />
                            <span>
                            Mon-Sun: 9:00AM - 9:00PM(Today)
                            </span>
                        </p>
                    </div>
                </div>
            </section>
            <Divider />
            <section className="pt-[2rem] lg:flex relative">
                <div className="space-y-10 lg:w-[20%] filter">
                    <div className="box">

                    </div>
                </div>
                <div className="space-y-5 lg:w-[80%] lg:pl-10">

                </div>
            </section>
        </div>
    )
}
export default RestaurantDetails