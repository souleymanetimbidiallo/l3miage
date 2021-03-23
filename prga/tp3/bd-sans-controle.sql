
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `base_bousse`
--

-- --------------------------------------------------------

--
-- Structure de la table `TP5_GRILLE`
--

CREATE TABLE IF NOT EXISTS `TP5_GRILLE` (
  `num_grille` int(11) NOT NULL,
  `nom_grille` varchar(100) COLLATE latin1_general_cs NOT NULL,
  `largeur` int(11) NOT NULL,
  `hauteur` int(11) NOT NULL,
  `controle` varchar(2000) COLLATE latin1_general_cs NOT NULL,
  PRIMARY KEY (`num_grille`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Contenu de la table `TP5_GRILLE`
--

INSERT INTO `TP5_GRILLE` (`num_grille`, `nom_grille`, `largeur`, `hauteur`, `controle`) VALUES
(1, 'Anglais moyen 1', 9, 9, ''),
(2, 'Anglais moyen 2', 9, 9, ''),
(3, 'Anglais moyen 3', 9, 9, ''),
(4, 'Anglais moyen 4', 9, 9, ''),
(5, 'Anglais moyen 5', 9, 9, ''),
(6, 'Anglais moyen 6', 15, 15, ''),
(7, 'Anglais moyen 7', 15, 15, ''),
(8, 'Anglais moyen 8', 15, 15, ''),
(9, 'NYT expert', 15, 15, ''),
(10, 'Français débutants', 6, 7, ''),
(11, 'Une (toute) petite grille de Georges Perec', 1, 1, '');

-- --------------------------------------------------------

--
-- Structure de la table `TP5_MOT`
--

CREATE TABLE IF NOT EXISTS `TP5_MOT` (
  `num_mot` int(11) NOT NULL AUTO_INCREMENT,
  `definition` varchar(256) COLLATE latin1_general_cs NOT NULL,
  `horizontal` tinyint(4) NOT NULL,
  `ligne` int(11) NOT NULL,
  `colonne` int(11) NOT NULL,
  `solution` varchar(64) COLLATE latin1_general_cs NOT NULL,
  `num_grille` int(11) NOT NULL,
  PRIMARY KEY (`num_mot`),
  KEY `FK1_MOT` (`num_grille`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs AUTO_INCREMENT=459 ;

--
-- Contenu de la table `TP5_MOT`
--

INSERT INTO `TP5_MOT` (`num_mot`, `definition`, `horizontal`, `ligne`, `colonne`, `solution`, `num_grille`) VALUES
(1, 'Not fail', 1, 1, 1, 'pass', 1),
(2, 'Wrinkly dog', 0, 1, 1, 'pug', 1),
(3, 'Went too fast', 1, 1, 6, 'sped', 1),
(4, 'Snatch', 1, 3, 1, 'grab', 1),
(5, 'Percussion instrument', 1, 3, 6, 'drum', 1),
(6, 'Put to work', 1, 4, 4, 'use', 1),
(7, 'British submachine gun', 1, 5, 1, 'sten', 1),
(8, 'Command post', 1, 5, 6, 'base', 1),
(9, 'Negating word', 1, 6, 4, 'not', 1),
(10, 'Skeletal', 1, 7, 1, 'bony', 1),
(11, 'Quench', 1, 7, 6, 'sate', 1),
(12, 'Big brass instrument', 1, 9, 1, 'tuba', 1),
(13, 'Large lot size', 1, 9, 6, 'acre', 1),
(14, 'Neptune''s realm', 0, 1, 3, 'sea', 1),
(15, 'Better than a bogey', 0, 1, 7, 'par', 1),
(16, 'Make less bright', 0, 1, 9, 'dim', 1),
(17, 'Fashionably dated', 0, 3, 2, 'retro', 1),
(18, 'Cottontail', 0, 3, 4, 'bunny', 1),
(19, 'Owed amounts', 0, 3, 6, 'debts', 1),
(20, 'Distressed', 0, 3, 8, 'upset', 1),
(21, 'Gamble', 0, 7, 1, 'bet', 1),
(22, 'Pen tip', 0, 7, 3, 'nib', 1),
(23, 'Part of a circle', 0, 7, 7, 'arc', 1),
(24, 'Female sheep', 0, 7, 9, 'ewe', 1),
(25, 'Wee drink', 1, 1, 4, 'sip', 2),
(26, 'Spill the beans', 1, 2, 1, 'tell', 2),
(27, '"My bad!"', 1, 2, 6, 'oops', 2),
(28, 'Everything', 1, 3, 4, 'all', 2),
(29, 'Bleak', 1, 4, 1, 'grim', 2),
(30, 'Floor or table light', 1, 4, 6, 'lamp', 2),
(31, 'Small storage structure', 1, 6, 1, 'shed', 2),
(32, 'Rouse from sleep', 1, 6, 6, 'wake', 2),
(33, 'Make do', 1, 7, 4, 'eke', 2),
(34, 'Volcanic flow', 1, 8, 1, 'lava', 2),
(35, 'British title', 1, 8, 6, 'earl', 2),
(36, 'Passing fancy', 1, 9, 4, 'fad', 2),
(37, 'Pooh, for one', 0, 1, 2, 'bear', 2),
(38, 'Close a door loudly', 0, 1, 4, 'slam', 2),
(39, 'Survey', 0, 1, 6, 'poll', 2),
(40, 'E-junk mail', 0, 1, 8, 'spam', 2),
(41, 'Pump it into cars', 0, 4, 1, 'gas', 2),
(42, 'Summer cooler', 0, 4, 3, 'ice', 2),
(43, 'American Automobile Assoc.', 0, 4, 7, 'aaa', 2),
(44, 'A dessert', 0, 4, 9, 'pie', 2),
(45, 'Leader', 0, 6, 2, 'head', 2),
(46, 'Unhearing', 0, 6, 4, 'deaf', 2),
(47, 'Garden intruder', 0, 6, 6, 'weed', 2),
(48, 'Small motor vehicle', 0, 6, 8, 'kart', 2),
(49, 'Evidence', 1, 1, 1, 'proof', 3),
(50, 'Supply with weapons', 1, 1, 7, 'arm', 3),
(51, 'Canadian Z', 1, 3, 1, 'zed', 3),
(52, 'English assignment', 1, 3, 5, 'essay', 3),
(53, 'Wound', 1, 5, 1, 'hurt', 3),
(54, 'Practice boxing', 1, 5, 6, 'spar', 3),
(55, 'Learner', 1, 7, 1, 'pupil', 3),
(56, 'Perform in a play', 1, 7, 7, 'act', 3),
(57, 'Informal room', 1, 9, 1, 'den', 3),
(58, 'Sudden fright', 1, 9, 5, 'panic', 3),
(59, 'Dispenser candy', 0, 1, 1, 'pez', 3),
(60, 'Sequence of items', 0, 1, 3, 'order', 3),
(61, 'Be anxious', 0, 1, 5, 'fret', 3),
(62, 'TV spots', 0, 1, 7, 'ads', 3),
(63, 'City official', 0, 1, 9, 'mayor', 3),
(64, 'Wished', 0, 5, 1, 'hoped', 3),
(65, 'Run-of-the-mill', 0, 5, 7, 'plain', 3),
(66, 'Trim', 0, 6, 5, 'clip', 3),
(67, 'Writing utensil', 0, 7, 3, 'pen', 3),
(68, 'Muscle spasm', 0, 7, 9, 'tic', 3),
(69, 'Young man', 1, 1, 1, 'boy', 4),
(70, 'Not the beginning', 1, 1, 7, 'end', 4),
(71, 'FBI officer', 1, 2, 3, 'agent', 4),
(72, 'Quick swim', 1, 3, 1, 'dip', 4),
(73, 'Stun', 1, 3, 7, 'awe', 4),
(74, 'Secret agent', 1, 4, 4, 'spy', 4),
(75, 'One sheet of paper', 1, 5, 1, 'page', 4),
(76, 'Consumes food', 1, 5, 6, 'eats', 4),
(77, 'TV spots', 1, 6, 4, 'ads', 4),
(78, 'Halloween mo.', 1, 7, 1, 'oct', 4),
(79, 'Part of a circle', 1, 7, 7, 'arc', 4),
(80, 'Impromptu', 1, 8, 3, 'adlib', 4),
(81, 'Meat from pig', 1, 9, 1, 'ham', 4),
(82, 'Car for hire', 1, 9, 7, 'cab', 4),
(83, 'Small dog sound', 0, 1, 3, 'yap', 4),
(84, 'Hold on to', 0, 1, 5, 'keep', 4),
(85, 'Airport acronym', 0, 1, 7, 'eta', 4),
(86, 'color your hair', 0, 1, 9, 'dye', 4),
(87, 'Sir ___ Newton', 0, 3, 2, 'isaac', 4),
(88, 'H2O', 0, 3, 8, 'water', 4),
(89, 'Neptune''s realm', 0, 4, 4, 'sea', 4),
(90, 'Affirmative', 0, 4, 6, 'yes', 4),
(91, 'Cold cuts place', 0, 6, 5, 'deli', 4),
(92, '"__-la-la"', 0, 7, 1, 'ooh', 4),
(93, 'Highland headgear', 0, 7, 3, 'tam', 4),
(94, 'Beginning of alphabet', 0, 7, 7, 'abc', 4),
(95, 'Chicago player', 0, 7, 9, 'cub', 4),
(96, 'Abbott, Lou''s partner', 0, 1, 1, 'bud', 4),
(97, 'Octet number', 1, 1, 1, 'eight', 5),
(98, 'Cloth fragment', 1, 1, 7, 'rag', 5),
(99, 'Time gone by', 1, 2, 5, 'ago', 5),
(100, 'Jockey', 1, 3, 1, 'rider', 5),
(101, 'Make a hole', 1, 3, 7, 'dig', 5),
(102, 'Pandemonium', 1, 5, 1, 'riot', 5),
(103, 'Well behaved', 1, 5, 6, 'good', 5),
(104, 'Lighted', 1, 7, 1, 'lit', 5),
(105, 'Planetary path', 1, 7, 5, 'orbit', 5),
(106, 'Self image', 1, 8, 3, 'ego', 5),
(107, 'Pub', 1, 9, 1, 'bar', 5),
(108, 'Wild cat', 1, 9, 5, 'tiger', 5),
(109, 'Blunder', 0, 1, 1, 'error', 5),
(110, 'Part of TGIF', 0, 1, 3, 'god', 5),
(111, 'Small pie', 0, 1, 5, 'tart', 5),
(112, 'Wild West show', 0, 1, 7, 'rodeo', 5),
(113, 'Comedian''s booking', 0, 1, 9, 'gig', 5),
(114, 'Exterior', 0, 5, 3, 'outer', 5),
(115, 'Frighten off', 0, 5, 9, 'deter', 5),
(116, 'Winter footware', 0, 6, 5, 'boot', 5),
(117, 'Laboratory', 0, 7, 1, 'lab', 5),
(118, 'Not average, but not huge', 0, 7, 7, 'big', 5),
(119, 'Sib.', 1, 1, 2, 'bro', 6),
(120, 'Nuisance', 1, 1, 6, 'pest', 6),
(121, 'Cup lip', 1, 1, 11, 'brim', 6),
(122, 'Perceive by touch', 1, 2, 1, 'feel', 6),
(123, 'Apiece', 1, 2, 6, 'each', 6),
(124, 'Actress Zellweger or Taylor', 1, 2, 11, 'renee', 6),
(125, 'Past due', 1, 3, 1, 'late', 6),
(126, 'Opera solo', 1, 3, 6, 'aria', 6),
(127, 'Put into words', 1, 3, 11, 'utter', 6),
(128, 'Make a mistake', 1, 4, 1, 'err', 6),
(129, 'Hostel', 1, 4, 5, 'inn', 6),
(130, 'Food from a shell', 1, 4, 9, 'nut', 6),
(131, 'Russian river', 1, 4, 13, 'oka', 6),
(132, 'Spruce up', 1, 5, 1, 'adorn', 6),
(133, 'Color of blood', 1, 5, 10, 'red', 6),
(134, 'Utilise', 1, 6, 4, 'use', 6),
(135, 'Chum', 1, 6, 8, 'pal', 6),
(136, 'Choir voice', 1, 6, 12, 'alto', 6),
(137, 'Buggy', 1, 7, 1, 'cart', 6),
(138, 'Vaccine pioneer', 1, 7, 6, 'salk', 6),
(139, 'Flock member', 1, 7, 12, 'bird', 6),
(140, 'Chicken _ __ King', 1, 8, 1, 'ala', 6),
(141, 'Ordinary', 1, 8, 6, 'plain', 6),
(142, '___ Grande', 1, 8, 13, 'rio', 6),
(143, 'Pencil puzzle', 1, 9, 1, 'maze', 6),
(144, 'Sicilian spa', 1, 9, 7, 'enna', 6),
(145, '"To __ __ not to..."', 1, 9, 12, 'beor', 6),
(146, 'Spanish 101 word', 1, 10, 1, 'eres', 6),
(147, 'Fall mo.', 1, 10, 6, 'oct', 6),
(148, 'Not me; thee', 1, 10, 10, 'you', 6),
(149, 'It rises and sets', 1, 11, 4, 'sun', 6),
(150, 'Concur', 1, 11, 11, 'agree', 6),
(151, 'Permit', 1, 12, 1, 'let', 6),
(152, 'Fall mo.', 1, 12, 5, 'sep', 6),
(153, 'Raiders of the Lost ___', 1, 12, 9, 'ark', 6),
(154, 'Unit of force', 1, 12, 13, 'erg', 6),
(155, 'Word of farewell', 1, 13, 1, 'adieu', 6),
(156, 'Top-rated', 1, 13, 7, 'aone', 6),
(157, 'Capture', 1, 13, 12, 'snag', 6),
(158, 'Ship of 1492', 1, 14, 1, 'pinta', 6),
(159, 'Spoils', 1, 14, 7, 'rots', 6),
(160, 'Cuban coin', 1, 14, 12, 'peso', 6),
(161, 'Greenish blue', 1, 15, 2, 'teal', 6),
(162, 'Make a sweater', 1, 15, 7, 'knit', 6),
(163, 'Astonishment', 1, 15, 12, 'awe', 6),
(164, 'Billy goat feature', 0, 1, 2, 'beard', 6),
(165, 'Fashionably dated', 0, 1, 3, 'retro', 6),
(166, 'Spanish cheer', 0, 1, 4, 'ole', 6),
(167, 'Hymn to Apollo', 0, 1, 6, 'pean', 6),
(168, 'Merit', 0, 1, 7, 'earn', 6),
(169, '___-fi', 0, 1, 8, 'sci', 6),
(170, 'Comparison word', 0, 1, 9, 'than', 6),
(171, 'Savage sort', 0, 1, 11, 'brute', 6),
(172, 'No longer working (abbr.)', 0, 1, 12, 'ret', 6),
(173, 'Division word', 0, 1, 13, 'into', 6),
(174, 'Docile', 0, 1, 14, 'meek', 6),
(175, 'Biting insect', 0, 2, 1, 'flea', 6),
(176, 'Memorable period of time', 0, 2, 15, 'era', 6),
(177, 'PC key', 0, 4, 5, 'ins', 6),
(178, 'Browser bookmark', 0, 4, 10, 'url', 6),
(179, 'Groove', 0, 5, 4, 'rut', 6),
(180, 'Bit of butter', 0, 5, 12, 'dab', 6),
(181, 'Psychic''s claim', 0, 6, 6, 'esp', 6),
(182, 'Factory', 0, 6, 8, 'plant', 6),
(183, 'Related (to)', 0, 6, 9, 'akin', 6),
(184, 'Old Italian money', 0, 6, 13, 'lire', 6),
(185, 'Duet plus one', 0, 6, 14, 'trio', 6),
(186, 'Stench', 0, 6, 15, 'odor', 6),
(187, 'Arrived', 0, 7, 1, 'came', 6),
(188, 'Winged', 0, 7, 2, 'alar', 6),
(189, 'Bulldoze', 0, 7, 3, 'raze', 6),
(190, 'Actor Baldwin', 0, 7, 7, 'alec', 6),
(191, 'Dissenting vote', 0, 8, 10, 'nay', 6),
(192, 'Double curved letter', 0, 9, 4, 'ess', 6),
(193, 'Glitch', 0, 9, 12, 'bug', 6),
(194, 'Single number', 0, 10, 6, 'one', 6),
(195, 'Type of tree', 0, 10, 11, 'oak', 6),
(196, 'Habitual', 0, 11, 5, 'usual', 6),
(197, 'Extend a subscription', 0, 11, 13, 'renew', 6),
(198, 'Rub out', 0, 11, 14, 'erase', 6),
(199, 'Pop-up breakfast brand', 0, 11, 15, 'eggo', 6),
(200, 'Once around the track', 0, 12, 1, 'lap', 6),
(201, 'Alter text', 0, 12, 2, 'edit', 6),
(202, 'Pitchfork feature', 0, 12, 3, 'tine', 6),
(203, 'Picnic site', 0, 12, 7, 'park', 6),
(204, 'Against', 0, 12, 9, 'anti', 6),
(205, 'Take it easy', 0, 12, 10, 'rest', 6),
(206, 'Airport acronym', 0, 13, 4, 'eta', 6),
(207, 'Suffix with ball or bass', 0, 13, 8, 'oon', 6),
(208, 'Relaxing resort', 0, 13, 12, 'spa', 6),
(209, 'School orgs.', 1, 1, 1, 'ptas', 7),
(210, 'Regard', 1, 1, 6, 'deem', 7),
(211, 'Start of a Dickens title', 1, 1, 11, 'atale', 7),
(212, 'Roof edge', 1, 2, 1, 'eave', 7),
(213, 'Notion', 1, 2, 6, 'idea', 7),
(214, 'Pass along', 1, 2, 11, 'relay', 7),
(215, 'A Baldwin brother', 1, 3, 1, 'alec', 7),
(216, 'Misters', 1, 3, 6, 'sirs', 7),
(217, 'Shut', 1, 3, 11, 'close', 7),
(218, 'Fix', 1, 4, 1, 'correction', 7),
(219, 'Allows', 1, 4, 12, 'lets', 7),
(220, 'Adolescents', 1, 6, 4, 'teen', 7),
(221, 'Jupiter, e.g.', 1, 6, 10, 'planet', 7),
(222, 'Touch lightly', 1, 7, 1, 'pat', 7),
(223, 'Damon or Dillon', 1, 7, 6, 'matt', 7),
(224, 'Animated', 1, 7, 11, 'alive', 7),
(225, 'Burdensome', 1, 8, 1, 'onerous', 7),
(226, 'Matured', 1, 8, 9, 'ripened', 7),
(227, 'Stroke a guitar', 1, 9, 1, 'strum', 7),
(228, 'Tibet''s continent', 1, 9, 7, 'asia', 7),
(229, 'Printing measures', 1, 9, 13, 'ens', 7),
(230, 'Wimbledon game', 1, 10, 1, 'tennis', 7),
(231, 'Hermit', 1, 10, 8, 'loner', 7),
(232, 'Gaze steadily', 1, 11, 4, 'stare', 7),
(233, 'Musical show', 1, 11, 11, 'revue', 7),
(234, 'Hindu garb', 1, 12, 1, 'sari', 7),
(235, 'About', 1, 12, 6, 'concerning', 7),
(236, 'Keyword wood', 1, 13, 1, 'ebony', 7),
(237, 'Aroma', 1, 13, 7, 'odor', 7),
(238, 'Water whirl', 1, 13, 12, 'eddy', 7),
(239, 'Delight', 1, 14, 1, 'elate', 7),
(240, 'Trucker''s vehicle', 1, 14, 7, 'semi', 7),
(241, 'Cry', 1, 14, 12, 'weep', 7),
(242, 'Evil spirit', 1, 15, 1, 'demon', 7),
(243, 'Family chart', 1, 15, 7, 'tree', 7),
(244, 'Classify', 1, 15, 12, 'sort', 7),
(245, '__ and quiet', 0, 1, 1, 'peace', 7),
(246, 'Vulture''s claw', 0, 1, 2, 'talon', 7),
(247, 'Ward off', 0, 1, 3, 'avert', 7),
(248, 'Confidential', 0, 1, 4, 'secret', 7),
(249, 'Part of DJ', 0, 1, 6, 'disc', 7),
(250, 'Rewrite', 0, 1, 7, 'edit', 7),
(251, 'Weirdest', 0, 1, 8, 'eeriest', 7),
(252, 'Stone worker', 0, 1, 9, 'mason', 7),
(253, 'Rainbow shape', 0, 1, 11, 'arc', 7),
(254, 'Blabblemouth', 0, 1, 12, 'telltale', 7),
(255, 'Medicinal plant', 0, 1, 13, 'aloe', 7),
(256, 'Endure', 0, 1, 14, 'last', 7),
(257, 'Storm center', 0, 1, 15, 'eyes', 7),
(258, 'Before, poetically', 0, 4, 5, 'ere', 7),
(259, 'Siesta', 0, 4, 10, 'nap', 7),
(260, 'Thunder sound', 0, 5, 11, 'clap', 7),
(261, 'Aussie creature', 0, 6, 6, 'emu', 7),
(262, 'Space agency (abbr.), ', 0, 6, 7, 'nasa', 7),
(263, 'Three squared', 0, 6, 13, 'nine', 7),
(264, 'Uniform', 0, 6, 14, 'even', 7),
(265, 'Koppel or Turner', 0, 6, 15, 'teds', 7),
(266, 'Pillar', 0, 7, 1, 'post', 7),
(267, 'Poker payment', 0, 7, 2, 'ante', 7),
(268, 'Shore bird', 0, 7, 3, 'tern', 7),
(269, 'Threesome', 0, 7, 9, 'trio', 7),
(270, 'Encounters (2 wds.)', 0, 8, 4, 'runsinto', 7),
(271, 'Exclude', 0, 8, 5, 'omit', 7),
(272, 'Author ___ Fleming', 0, 8, 10, 'ian', 7),
(273, 'Skinny', 0, 9, 8, 'slender', 7),
(274, 'Cul-de____', 0, 10, 6, 'sac', 7),
(275, 'Misjudge', 0, 10, 11, 'err', 7),
(276, 'Extends (a subscription), ', 0, 10, 12, 'renews', 7),
(277, 'Hen''s perch', 0, 11, 7, 'roost', 7),
(278, 'MTV feature', 0, 11, 13, 'video', 7),
(279, 'Below', 0, 11, 14, 'under', 7),
(280, 'Cairo''s land', 0, 11, 15, 'egypt', 7),
(281, 'Plaint''s beginning', 0, 12, 1, 'seed', 7),
(282, 'Skilled', 0, 12, 2, 'able', 7),
(283, 'Ramble', 0, 12, 3, 'roam', 7),
(284, 'Show up', 0, 12, 9, 'come', 7),
(285, 'Albany''s canal', 0, 12, 10, 'erie', 7),
(286, 'Desire', 0, 13, 5, 'yen', 7),
(287, 'Come in', 1, 5, 1, 'enter', 7),
(288, 'Put into effect', 1, 5, 8, 'enact', 7),
(289, 'Strike-breaker', 1, 1, 1, 'scab', 8),
(290, 'Assists', 1, 1, 6, 'aids', 8),
(291, 'Treaties', 1, 1, 11, 'pacts', 8),
(292, 'Cuckoo', 1, 2, 1, 'loco', 8),
(293, 'Mild oath', 1, 2, 6, 'drat', 8),
(294, 'Characteristic', 1, 2, 11, 'trait', 8),
(295, 'Isn''t, incorrectly', 1, 3, 1, 'aint', 8),
(296, 'Better half', 1, 3, 6, 'mate', 8),
(297, 'Major artery', 1, 3, 11, 'aorta', 8),
(298, 'Entreaty', 1, 4, 1, 'plea', 8),
(299, 'Thinker ___ Newton', 1, 4, 6, 'isaac', 8),
(300, 'Shopper''s paradise', 1, 4, 12, 'mall', 8),
(301, 'Fish trap', 1, 5, 4, 'net', 8),
(302, 'Aquatic mammal', 1, 5, 9, 'manatee', 8),
(303, 'Diva ___ Callas', 1, 6, 1, 'maria', 8),
(304, 'Cheapskate', 1, 6, 7, 'miser', 8),
(305, 'Atom part', 1, 7, 1, 'electron', 8),
(306, 'African adventure', 1, 7, 10, 'safari', 8),
(307, 'Fizzy drink', 1, 8, 1, 'soda', 8),
(308, 'Nebraska metropolis', 1, 8, 6, 'omaha', 8),
(309, 'Not up yet', 1, 8, 12, 'abed', 8),
(310, 'Obtained illegally', 1, 9, 1, 'stolen', 8),
(311, '___ port', 1, 9, 8, 'parallel', 8),
(312, 'Delicious', 1, 10, 5, 'tasty', 8),
(313, 'Fashion', 1, 10, 11, 'style', 8),
(314, 'Magazine item', 1, 11, 1, 'article', 8),
(315, 'That gal', 1, 11, 10, 'she', 8),
(316, 'Borrowed money', 1, 12, 1, 'loan', 8),
(317, 'Fox trot, e.g.', 1, 12, 6, 'dance', 8),
(318, 'Move upward', 1, 12, 12, 'rise', 8),
(319, 'Grown-up', 1, 13, 1, 'adult', 8),
(320, 'Complain', 1, 13, 7, 'moan', 8),
(321, 'Golden calf, e.g.', 1, 13, 12, 'idol', 8),
(322, 'Subscribe again', 1, 14, 1, 'renew', 8),
(323, 'Military supplies', 1, 14, 7, 'ammo', 8),
(324, 'Singer ___ Diamond', 1, 14, 12, 'neil', 8),
(325, 'Slogan', 1, 15, 1, 'motto', 8),
(326, 'Not ever, poetically', 1, 15, 7, 'neer', 8),
(327, 'Brisk wind', 1, 15, 12, 'gale', 8),
(328, 'Smack', 0, 1, 1, 'slap', 8),
(329, 'Mattress part', 0, 1, 2, 'coil', 8),
(330, 'Pimples', 0, 1, 3, 'acne', 8),
(331, 'Pertainig to plants', 0, 1, 4, 'botanical', 8),
(332, 'Confess', 0, 1, 6, 'admit', 8),
(333, 'Retirees'' accts', 0, 1, 7, 'iras', 8),
(334, 'Information', 0, 1, 8, 'data', 8),
(335, 'Emits vapor', 0, 1, 9, 'steams', 8),
(336, 'School group (abbr.),', 0, 1, 11, 'pta', 8),
(337, 'Smell', 0, 1, 12, 'aroma', 8),
(338, 'Diamond weight', 0, 1, 13, 'carat', 8),
(339, 'Baron, e.g.', 0, 1, 14, 'title', 8),
(340, 'Like old bread', 0, 1, 15, 'stale', 8),
(341, 'Roman general', 0, 4, 10, 'caesar', 8),
(342, 'Take food', 0, 5, 5, 'eat', 8),
(343, 'Gun org.', 0, 5, 11, 'nra', 8),
(344, 'Army chow', 0, 6, 1, 'mess', 8),
(345, 'Great deal (2 wds.),', 0, 6, 2, 'alot', 8),
(346, 'Decorate anew', 0, 6, 3, 'redo', 8),
(347, 'Pop''s partner', 0, 6, 7, 'mom', 8),
(348, 'Not appropriate', 0, 6, 8, 'inapt', 8),
(349, 'President ___ Reagan', 0, 7, 6, 'ronald', 8),
(350, 'Hesitating', 0, 7, 12, 'faltering', 8),
(351, 'With completence', 0, 7, 13, 'ably', 8),
(352, 'Rod''s partner', 0, 7, 14, 'reel', 8),
(353, 'Jobless', 0, 7, 15, 'idle', 8),
(354, 'Horse food', 0, 8, 9, 'hay', 8),
(355, 'And so forth (abbr.),', 0, 9, 5, 'etc', 8),
(356, 'Hardwood tree', 0, 9, 11, 'ash', 8),
(357, 'Sailor', 0, 10, 7, 'seaman', 8),
(358, 'Warning signal', 0, 11, 1, 'alarm', 8),
(359, 'Cowboy show', 0, 11, 2, 'rodeo', 8),
(360, 'Tease', 0, 11, 3, 'taunt', 8),
(361, 'Small bay', 0, 11, 4, 'inlet', 8),
(362, 'Spanish "mister"', 0, 11, 10, 'senor', 8),
(363, 'Alaskan city', 0, 12, 8, 'nome', 8),
(364, 'Showed up', 0, 12, 9, 'came', 8),
(365, 'Inspiration', 0, 12, 13, 'idea', 8),
(366, 'Earth', 0, 12, 14, 'soil', 8),
(367, 'She, in Toulouse', 0, 12, 15, 'elle', 8),
(368, 'Couple', 0, 13, 5, 'two', 8),
(369, 'Order', 1, 1, 1, 'fiat', 9),
(370, '___ palm', 1, 1, 7, 'acai', 9),
(371, 'It''s made with syrup', 1, 1, 12, 'cola', 9),
(372, 'Town near Ireland''s Shannon Airport', 1, 2, 1, 'ennis', 9),
(373, 'A caller may be on this', 1, 2, 7, 'hold', 9),
(374, 'Track type', 1, 2, 12, 'oval', 9),
(375, '& (3,6) Italian-born composer', 1, 3, 1, 'monteverdi', 9),
(376, 'Something a scow lacks', 1, 3, 12, 'keel', 9),
(377, 'It''s often hooked', 1, 4, 1, 'bra', 9),
(378, 'Carlos the Jackal, for one', 1, 4, 5, 'nomdeguerre', 9),
(379, 'Start of a Beatles refrain', 1, 5, 1, 'obladi', 9),
(380, 'Eastern titles', 1, 5, 8, 'sris', 9),
(381, '___ loss', 1, 5, 13, 'ata', 9),
(382, 'Bars in cars', 1, 6, 1, 'tierods', 9),
(383, '"A ___ champion never handled sword": "Henry VI, Part I"', 1, 6, 9, 'stouter', 9),
(384, '"Understood"', 1, 7, 2, 'tenfour', 9),
(385, 'Danny''s love in "Ocean''s Eleven"', 1, 7, 12, 'tess', 9),
(386, '& (8,9) German-born composer', 1, 8, 4, 'offenbach', 9),
(387, 'Man''s name that spells a fruit backward', 1, 9, 1, 'emil', 9),
(388, 'Class lists?', 1, 9, 8, 'syllabi', 9),
(389, 'Takes one''s sweet time', 1, 10, 1, 'dawdles', 9),
(390, 'Kind of car or class', 1, 10, 9, 'economy', 9),
(391, '2014 Oscar winner for Best Foreign Language Film', 1, 11, 1, 'ida', 9),
(392, 'Space cadet''s need?', 1, 11, 5, 'clue', 9),
(393, 'Prompt', 1, 11, 10, 'ontime', 9),
(394, 'His first tweet ended "I bless all of you from my heart"', 1, 12, 1, 'benedictxvi', 9),
(395, 'What the lowing herd wind slowly o''er, in verse', 1, 12, 13, 'lea', 9),
(396, 'For the calorie-conscious', 1, 13, 1, 'lite', 9),
(397, '& (13,12) Austrian-born composer', 1, 13, 6, 'schoenberg', 9),
(398, 'N.B.A. coach Spoelstra', 1, 14, 1, 'erik', 9),
(399, 'Put on', 1, 14, 6, 'hoax', 9),
(400, 'Spiny shrub', 1, 14, 11, 'gorse', 9),
(401, 'Without', 1, 15, 1, 'sans', 9),
(402, 'Ligurian Sea feeder', 1, 15, 6, 'arno', 9),
(403, 'North Sea feeder', 1, 15, 12, 'yser', 9),
(404, '"Austin Powers" villain', 0, 1, 1, 'fembot', 9),
(405, 'Out of this world?', 0, 1, 2, 'inorbit', 9),
(406, 'Longtime grandmotherly "General Hospital" actress', 0, 1, 3, 'annalee', 9),
(407, 'Short-beaked bird', 0, 1, 4, 'tit', 9),
(408, '"Aren''t you forgetting something?"', 0, 1, 7, 'ahem', 9),
(409, 'Jumble behind a computer desk', 0, 1, 8, 'cords', 9),
(410, 'Hazel relatives', 0, 1, 9, 'alders', 9),
(411, '"Cool, man!"', 0, 1, 10, 'idigit', 9),
(412, 'Popular (1,12)-Across', 0, 1, 12, 'coke', 9),
(413, 'Gorged', 0, 1, 13, 'overate', 9),
(414, 'Shakespeare character who says "I dare damnation"', 0, 1, 14, 'laertes', 9),
(415, 'Paying close attention', 0, 1, 15, 'allears', 9),
(416, 'Retirement party, e.g.', 0, 2, 5, 'sendoff', 9),
(417, 'Without', 0, 3, 6, 'voidof', 9),
(418, 'Tour grp.', 0, 4, 11, 'uso', 9),
(419, '"Happy Days" malt shop owner', 0, 5, 4, 'arnold', 9),
(420, 'File certain papers', 0, 6, 7, 'sue', 9),
(421, '"View From the U.N." memoirist', 0, 6, 12, 'uthant', 9),
(422, 'Hosp. staffers', 0, 7, 8, 'rns', 9),
(423, 'Cry that''s often doubled', 0, 8, 9, 'bye', 9),
(424, 'Place for a bust', 0, 8, 10, 'alcove', 9),
(425, 'Doubling up?', 0, 8, 11, 'cloning', 9),
(426, 'Food', 0, 9, 1, 'edibles', 9),
(427, 'Port alternative', 0, 9, 2, 'madeira', 9),
(428, '"Sign me up!"', 0, 9, 3, 'iwantin', 9),
(429, 'Heating equipment', 0, 9, 13, 'boilers', 9),
(430, 'Put completely (in)', 0, 9, 14, 'immerse', 9),
(431, 'TV option, for short', 0, 10, 5, 'lcd', 9),
(432, 'Engineer Gray who co-founded Western Electric', 0, 10, 6, 'elisha', 9),
(433, 'Aid', 0, 10, 7, 'succor', 9),
(434, 'Shepard''s role in "The Right Stuff"', 0, 10, 15, 'yeager', 9),
(435, '___ Allen Express (Amtrak train in the Northeast)', 0, 11, 8, 'ethan', 9),
(436, 'Horror movie sounds', 0, 12, 4, 'eeks', 9),
(437, 'Letter ender', 0, 12, 9, 'xoxo', 9),
(438, '"Whew!"', 0, 13, 12, 'boy', 9),
(439, 'Tireur à l''arc', 1, 1, 1, 'archer', 10),
(440, 'Administration', 1, 2, 1, 'douane', 10),
(441, 'Mois', 1, 3, 1, 'juin', 10),
(442, 'Détiennent', 1, 4, 1, 'ont', 10),
(443, 'Version originale', 1, 4, 5, 'vo', 10),
(444, 'La même chose', 1, 5, 1, 'id', 10),
(445, 'Alcool anglais', 1, 5, 4, 'gin', 10),
(446, 'Restitue', 1, 6, 3, 'rend', 10),
(447, 'Supporters italiens', 1, 7, 1, 'tifosi', 10),
(448, 'Associé', 0, 1, 1, 'adjoint', 10),
(449, 'Reprise en boxe', 0, 1, 2, 'round', 10),
(450, 'Chauffé', 0, 1, 3, 'cuit', 10),
(451, 'La France au fronton', 0, 6, 3, 'rf', 10),
(452, 'A gauche d''Hannibal', 0, 1, 4, 'han', 10),
(453, 'Cours court', 0, 5, 4, 'geo', 10),
(454, 'Préposition', 0, 1, 5, 'en', 10),
(455, 'Boissons', 0, 4, 5, 'vins', 10),
(456, 'Bien rond, joufflu', 0, 1, 6, 'rebondi', 10),
(457, 'Voyelle', 1, 1, 1, 'I', 11),
(458, 'Consonne', 0, 1, 1, 'I', 11);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `TP5_MOT`
--
ALTER TABLE `TP5_MOT`
  ADD CONSTRAINT `TP5_MOT_ibfk_1` FOREIGN KEY (`num_grille`) REFERENCES `TP5_GRILLE` (`num_grille`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
