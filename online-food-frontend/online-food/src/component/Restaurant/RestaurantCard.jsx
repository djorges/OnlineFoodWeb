import React from 'react';
import {Card, Chip, IconButton} from "@mui/material";
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';


const RestaurantCard = () =>{
    return (
        <Card className="w-[18rem]">
            <div className={`${true? 'cursor-pointer':'cursor-not-allowed'} relative`}>
                <img
                    className="w-full h-[10rem] rounded-t-md object-cover"
                    src="./restaurants/American fast food restaurant.jpg"
                    alt=""
                />
                <Chip
                    size="small"
                    className="absolute top-2 left-2"
                    color={true?"success":"error"}
                    label={true?"open":"closed"}
                />
                <div className="textPart p-4 lg:flex w-full justify-between">
                    <div className="space-y-1">
                        <p className="font-semibold text-lg">American Fast Food</p>
                        <p className="text-gray-500 text-sm">5 Star Restaurant.</p>
                    </div>
                    <div>
                        <IconButton>
                            {true?<FavoriteIcon/>:<FavoriteBorderIcon/>}
                        </IconButton>
                    </div>
                </div>
            </div>
        </Card>
    )
}

export default RestaurantCard