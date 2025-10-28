import React from 'react';
import { createRoot } from 'react-dom/client';
import { useState } from 'react';

const htmlelement = document.getElementById('root');
const rootreact = createRoot(htmlelement);

const Header = () => {
  const [menuOpen, setMenuOpen] = useState(false);
  const toggleMenu = () => {
    setMenuOpen(!menuOpen);
  };

  return (
    <>
      <header>
        <span id='span1' className='home'>Home</span>
        {/* menu bar */}
        <div onClick={toggleMenu}>
          <span className="bar"></span>
          <span className="bar"></span>
          <span className="bar"></span>
        </div>
        <span className={menuOpen ? 'menu-open' : 'menu-closed'}>
          <span id='span2' className='news'>News</span>
          <span id='span3' className='contact'>Contact</span>
          <span id='span4' className='about'>About</span> </span>
      </header>
    </>
  );
}

const App = () => {
  return (
    <span>
      <Header />
    </span>
  );
}

rootreact.render(<App />);
