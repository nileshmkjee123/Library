import { Navbar } from './../NavBarAndFooter/NavBar';
import {ExploreTopBooks} from './components/ExploreTopBooks';
import { Carousel } from './components/Carousel';
import { Heros } from './components/Heros';
import { LibraryServices } from './components/LibraryServices';
import { Footer } from './components/Footer';
export const HomePage = () => {
    return(
        <>
        <Navbar />
   <ExploreTopBooks />
   <Carousel />
   <Heros />
   <LibraryServices />
   <Footer />
        </>
    );
}