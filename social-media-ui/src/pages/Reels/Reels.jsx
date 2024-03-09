import React, { useEffect, useRef, useState } from "react";
import ReelsCard from "./ReelsCard";
import { reels } from "./ReelsData";
import Slider from "react-slick";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import { Button, Card, IconButton } from "@mui/material";
import ArrowBackIosIcon from "@mui/icons-material/ArrowBackIos";
import ArrowForwardIosIcon from "@mui/icons-material/ArrowForwardIos";
import { ArrowBackIosNew } from "@mui/icons-material";
import { useDispatch, useSelector } from "react-redux";
import { getAllReels } from "../../Redux/Reels/reels.acton";
const settings = {
  infinite: true,
  speed: 500,
  slidesToShow: 1,
  slidesToScroll: 1,
  // vertical: true,
  autoplay: false,
  cssEase: "linear",
  arrows: false,
};
const Reels = () => {
  const dispatch = useDispatch();
  const { reel, comment, auth } = useSelector((store) => store);

  useEffect(() => {
    dispatch(getAllReels());
  }, [dispatch, comment.create, auth.token]);

  const sliderRef = useRef(null);

  const handleNext = () => {
    sliderRef.current.slickNext();
  };

  const handlePrevious = () => {
    sliderRef.current.slickPrev();
  };

  return (
    <div className="flex items-center h-screen ">
      <div className="relative ">
        <Slider className=" h-[95vh] w-[25rem]" ref={sliderRef} {...settings}>
          {reel.reels.map((reel) => (
            <Card className="" key={reel.id}>
              <ReelsCard key={reel.id} reel={reel} video={reel.video} />
              {/* <video
                className="h-screen"
                src={reel.video}
                   autoPlay
                controls
              /> */}
            </Card>
          ))}
          <div></div>
        </Slider>
        <div className="absolute top-1/2 -left-32">
          <IconButton color="primary" onClick={handlePrevious}>
            <ArrowBackIosIcon />
          </IconButton>
        </div>
        <div className="absolute top-1/2 -right-32">
          <IconButton color="primary" onClick={handleNext}>
            <ArrowForwardIosIcon />
          </IconButton>
        </div>
      </div>
    </div>
  );
};

export default Reels;
