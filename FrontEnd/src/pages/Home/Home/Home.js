import React from "react";
import Clients from "../../Clients/Clients";
import Features from "../../Features/Features";
import Services from "../../Services/Services";
import PageTitle from "../../Shared/PageTitle/PageTitle";
import Banner from "../Banner/Banner";
const Home=()=>{
    return (
        <>
        <PageTitle title="Home"></PageTitle>
        <Banner></Banner>
        <Features></Features>
        <Services></Services>
        <Clients></Clients>
        </>
    )
}
export default Home;