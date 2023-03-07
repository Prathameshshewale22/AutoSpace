import React from "react";
import Clients from "../../Clients/Clients";
import Features from "../../Features/Features";
import Services from "../../Services/Services";
import PageTitle from "../../Shared/PageTitle/PageTitle";
import Banner from "../Banner/Banner";
import ServiceCenters from "../../ServiceCenters/ServiceCenters";
const Home=()=>{
    return (
        <>
        <PageTitle title="Home"></PageTitle>
        <Banner></Banner>
        <Services></Services>
        <ServiceCenters></ServiceCenters>
        <Features></Features>
        
        <Clients></Clients>
        </>
    )
}
export default Home;