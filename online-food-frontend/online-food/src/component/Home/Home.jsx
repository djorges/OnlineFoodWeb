import React from 'react';
import "./Home.css";
import MultiItemCarousel from "./MultiItemCarousel";
import RestaurantCard from "../Restaurant/RestaurantCard";


const restaurants = [1,1,1,1,1];
const Home = () =>{
    return (
        <div className="pb-10">
            <section className="banner relative flex flex-col justify-center items-center">
                {/*Title*/}
                <div className="w-[50vw] z-10 text-center">
                    <p className="text-2xl lg:text-6xl font-bold z-10 py-5">Online Food</p>
                    <p className="text-xl lg:text-4xl text-gray-300 z-10">Taste your favourite food.</p>
                </div>
                {/**/}
                <div className="cover absolute top-0 left-0 right-0">

                </div>
                {/**/}
                <div className="fadeout">

                </div>
            </section>
            <section className="p-10 lg:py-10 lg:px-20">
                {/*Top Meals*/}
                <p className="text-2xl font-semibold text-gray-400 py-3 pb-10">Top Meals</p>
                <MultiItemCarousel />
            </section>
            <section className="px-5 lg:px-20 pt-10">
                {/*Restaurants*/}
                <h1 className="text-2xl font-semibold text-gray-400 pb-8">Order From Our Handpicked Favorites</h1>
                <div className="flex flex-wrap items-center justify-around gap-5">
                    {
                        restaurants.map((item) => <RestaurantCard/>)
                    }
                </div>
            </section>
        </div>
    )
}

export default Home