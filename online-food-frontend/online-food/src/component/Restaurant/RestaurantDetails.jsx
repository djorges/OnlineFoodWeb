import React, {useState} from 'react';
import {Divider, FormControl, FormControlLabel, Grid, Radio, RadioGroup, Typography} from "@mui/material";
import LocationOnIcon from '@mui/icons-material/LocationOn';
import CalendarMonthIcon from '@mui/icons-material/CalendarMonth';
import MenuCard from "./MenuCard";

const categories= [
    "pizza",
    "burger",
    "chicken",
    "rice"
];
const foodTypes=[
    {label:"All", value: "all"},
    {label:"Vegetarian only", value: "vegetarian"},
    {label: "Non-Vegetarian", value: "non-vegetarian"},
    {label: "Seasonal", value: "seasonal"}
]
const menuItems = [1,2,3,2,2,2,2]

const RestaurantDetails = () =>{
    const [foodType, setFoodType] = useState("all");
    const handleFilter = (e)=>{
        console.log(e.target.value, e.target.name)
    }
    return(
        <div className="px-5 lg:px-20">
            <section>
                {/*Captures*/}
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
                {/*Description*/}
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
                {/*Filters*/}
                <div className="space-y-10 lg:w-[20%] filter">
                    <div className="box space-y-5 lg:sticky top-28">
                        <div>
                            <Typography variant="h5" sx={{paddingBottom:"1rem"}}>
                                Food Type
                            </Typography>

                            <FormControl className="py-10 space-y-5" component={"fieldset"}>
                                <RadioGroup name="food_type" value={foodType} onChange={handleFilter}>
                                    {foodTypes.map((item)=>(
                                        <FormControlLabel
                                            key={item.value}
                                            value={item.value}
                                            control={<Radio/>}
                                            label={item.label}/>
                                    ))}
                                </RadioGroup>
                            </FormControl>
                        </div>
                        <Divider/>
                        <div>
                            <Typography variant="h5" sx={{paddingBottom:"1rem"}}>
                                Food Category
                            </Typography>

                            <FormControl className="py-10 space-y-5" component={"fieldset"}>
                                <RadioGroup name="food_category" value={foodType} onChange={handleFilter}>
                                    {categories.map((item)=>(
                                        <FormControlLabel
                                            key={item}
                                            value={item}
                                            control={<Radio/>}
                                            label={item}/>
                                    ))}
                                </RadioGroup>
                            </FormControl>
                        </div>
                    </div>
                </div>
                {/*Menu*/}
                <div className="space-y-5 lg:w-[80%] lg:pl-10">
                    {menuItems.map((item)=><MenuCard />)}
                </div>
            </section>
        </div>
    )
}
export default RestaurantDetails