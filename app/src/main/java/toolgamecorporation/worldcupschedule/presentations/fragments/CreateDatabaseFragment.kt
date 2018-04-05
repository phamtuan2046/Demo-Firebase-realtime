package toolgamecorporation.worldcupschedule.presentations.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_create_database.*
import toolgamecorporation.worldcupschedule.R
import toolgamecorporation.worldcupschedule.common.Constance
import toolgamecorporation.worldcupschedule.common.TimeUtils
import toolgamecorporation.worldcupschedule.data.entity.MatchEntity
import toolgamecorporation.worldcupschedule.data.entity.StadiumEntity
import toolgamecorporation.worldcupschedule.data.entity.TeamEntity
import toolgamecorporation.worldcupschedule.data.entity.TeamSortEntity
import toolgamecorporation.worldcupschedule.data.models.Schedule

/**
 * Created by Dell on 3/25/2018.
 */
class CreateDatabaseFragment : BaseFragment(), ValueEventListener {
    private var mDatabase: DatabaseReference? = null
    private var schedule = ArrayList<Schedule>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDatabase = FirebaseDatabase.getInstance().reference
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_create_database, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnPush.setOnClickListener {
            createGroupA()
        }
    }

    override fun onCancelled(p0: DatabaseError?) {

    }

    override fun onDataChange(p0: DataSnapshot?) {

    }


    fun createDatabase1_3() {
        var matches = ArrayList<MatchEntity>()
        val userId = Constance.FIRST_STAGE_1_3
        var match1 = MatchEntity("2018-06-14 22:00 +0700", "Luzhniki Stadium", Constance.A)
        var team1_1 = TeamEntity("Russia")
        var team1_2 = TeamEntity("Saudi Arabia")
        //SET TI SO
//        team1_1.numberGoalar = 0
//        team1_2.numberGoalar = 0
        match1.teams.add(team1_1)
        match1.teams.add(team1_2)
        matches.add(match1)

        var match2 = MatchEntity("2018-06-15 19:00 +0700", "Ekaterinburg Arena", Constance.A)
        var team2_1 = TeamEntity("Egypt")
        var team2_2 = TeamEntity("Uruguay")
        //SET TI SO
//        team2_1.numberGoalar = 0
//        team2_2.numberGoalar = 0
        match2.teams.add(team2_1)
        match2.teams.add(team2_2)
        matches.add(match2)

        var match3 = MatchEntity("2018-06-15 22:00 +0700", "Saint Petersburg Stadium", Constance.B)
        var team3_1 = TeamEntity("Morocco")
        var team3_2 = TeamEntity("Iran")
        //SET TI SO
//        team3_1.numberGoalar = 0
//        team3_2.numberGoalar = 0
        match3.teams.add(team3_1)
        match3.teams.add(team3_2)
        matches.add(match3)

        var match4 = MatchEntity("2018-06-16 01:00 +0700", "Fisht Stadium", Constance.B)
        var team4_1 = TeamEntity("Portugal")
        var team4_2 = TeamEntity("Spain")
        //SET TI SO
//        team4_1.numberGoalar = 0
//        team4_2.numberGoalar = 0
        match4.teams.add(team4_1)
        match4.teams.add(team4_2)
        matches.add(match4)

        var match5 = MatchEntity("2018-06-16 17:00 +0700", "Kazan Arena ", Constance.C)
        var team5_1 = TeamEntity("France")
        var team5_2 = TeamEntity("Australia")
        //SET TI SO
//        team5_1.numberGoalar = 0
//        team5_2.numberGoalar = 0
        match5.teams.add(team5_1)
        match5.teams.add(team5_2)
        matches.add(match5)

        var match6 = MatchEntity("2018-06-16 20:00 +0700", "Spartak Stadium", Constance.D)
        var team6_1 = TeamEntity("Argentina")
        var team6_2 = TeamEntity("Iceland")
        //SET TI SO
//        team6_1.numberGoalar = 0
//        team6_2.numberGoalar = 0
        match6.teams.add(team6_1)
        match6.teams.add(team6_2)
        matches.add(match6)

        var match7 = MatchEntity("2018-06-16 23:00 +0700", "Mordovia Arena", Constance.C)
        var team7_1 = TeamEntity("Peru")
        var team7_2 = TeamEntity("Denmark")
        //SET TI SO
//        team7_1.numberGoalar = 0
//        team7_2.numberGoalar = 0
        match7.teams.add(team7_1)
        match7.teams.add(team7_2)
        matches.add(match7)

        var match8 = MatchEntity("2018-06-17 02:00 +0700", "Kaliningrad Stadium", Constance.D)
        var team8_1 = TeamEntity("Croatia")
        var team8_2 = TeamEntity("Nigeria")
        //SET TI SO
//        team8_1.numberGoalar = 0
//        team8_2.numberGoalar = 0
        match8.teams.add(team8_1)
        match8.teams.add(team8_2)
        matches.add(match8)

        var match9 = MatchEntity("2018-06-17 19:00 +0700", "Samara Arena", Constance.E)
        var team9_1 = TeamEntity("Costa Rica")
        var team9_2 = TeamEntity("Serbia")
        //SET TI SO
//        team9_1.numberGoalar = 0
//        team9_2.numberGoalar = 0
        match9.teams.add(team9_1)
        match9.teams.add(team9_2)
        matches.add(match9)

        var match10 = MatchEntity("2018-06-17 22:00 +0700", "Luzhniki Stadium", Constance.F)
        var team10_1 = TeamEntity("Germany")
        var team10_2 = TeamEntity("Mexico")
        //SET TI SO
//        team10_1.numberGoalar = 0
//        team10_2.numberGoalar = 0
        match10.teams.add(team10_1)
        match10.teams.add(team10_2)
        matches.add(match10)

        var match11 = MatchEntity("2018-06-18 01:00 +0700", "Rostov Arena", Constance.E)
        var team11_1 = TeamEntity("Brazil")
        var team11_2 = TeamEntity("Switzerland")
        //SET TI SO
//        team11_1.numberGoalar = 0
//        team11_2.numberGoalar = 0
        match11.teams.add(team11_1)
        match11.teams.add(team11_2)
        matches.add(match11)

        var match12 = MatchEntity("2018-06-18 19:00 +0700", "Nizhny Novgorod Stadium", Constance.F)
        var team12_1 = TeamEntity("Sweden")
        var team12_2 = TeamEntity("South Korea")
        //SET TI SO
//        team12_1.numberGoalar = 0
//        team12_2.numberGoalar = 0
        match12.teams.add(team12_1)
        match12.teams.add(team12_2)
        matches.add(match12)

        var match13 = MatchEntity("2018-06-18 22:00 +0700", "Fisht Stadium", Constance.G)
        var team13_1 = TeamEntity("Belgium")
        var team13_2 = TeamEntity("Panama")
        //SET TI SO
//        team13_1.numberGoalar = 0
//        team13_2.numberGoalar = 0
        match13.teams.add(team13_1)
        match13.teams.add(team13_2)
        matches.add(match13)

        var match14 = MatchEntity("2018-06-19 01:00 +0700", "Volgograd Arena", Constance.G)
        var team14_1 = TeamEntity("Tunisia")
        var team14_2 = TeamEntity("England")
        //SET TI SO
//        team14_1.numberGoalar = 0
//        team14_2.numberGoalar = 0
        match14.teams.add(team14_1)
        match14.teams.add(team14_2)
        matches.add(match14)

        var match15 = MatchEntity("2018-06-19 19:00 +0700", "Mordovia Arena", Constance.H)
        var team15_1 = TeamEntity("Colombia")
        var team15_2 = TeamEntity("Japan")
        //SET TI SO
//        team15_1.numberGoalar = 0
//        team15_2.numberGoalar = 0
        match15.teams.add(team15_1)
        match15.teams.add(team15_2)
        matches.add(match15)

        var match16 = MatchEntity("2018-06-19 22:00 +0700", "Spartak Stadium", Constance.H)
        var team16_1 = TeamEntity("Poland")
        var team16_2 = TeamEntity("Senegal")
        //SET TI SO
//        team16_1.numberGoalar = 0
//        team16_2.numberGoalar = 0
        match16.teams.add(team16_1)
        match16.teams.add(team16_2)
        matches.add(match16)
        mDatabase?.child(userId)?.setValue(matches)
    }

    fun createDatabase2_3() {
        var matches = ArrayList<MatchEntity>()
        val userId = Constance.FIRST_STAGE_2_3
        var match1 = MatchEntity("2018-06-20 01:00 +0700", "Saint Petersburg Stadium", Constance.A)
        var team1_1 = TeamEntity("Russia")
        var team1_2 = TeamEntity("Egypt")
        //SET TI SO
//        team1_1.numberGoalar = 0
//        team1_2.numberGoalar = 0
        match1.teams.add(team1_1)
        match1.teams.add(team1_2)
        matches.add(match1)

        var match2 = MatchEntity("2018-06-20 19:00 +0700", "Luzhniki Stadium", Constance.B)
        var team2_1 = TeamEntity("Portugal")
        var team2_2 = TeamEntity("Morocco")
        //SET TI SOA
//        team2_1.numberGoalar = 0
//        team2_2.numberGoalar = 0
        match2.teams.add(team2_1)
        match2.teams.add(team2_2)
        matches.add(match2)

        var match3 = MatchEntity("2018-06-20 22:00 +0700", "Rostov Arena", Constance.A)
        var team3_1 = TeamEntity("Uruguay")
        var team3_2 = TeamEntity("Saudi Arabia")
        //SET TI SO
//        team3_1.numberGoalar = 0
//        team3_2.numberGoalar = 0
        match3.teams.add(team3_1)
        match3.teams.add(team3_2)
        matches.add(match3)

        var match4 = MatchEntity("2018-06-21 01:00 +0700", "Kazan Arena", Constance.B)
        var team4_1 = TeamEntity("Iran")
        var team4_2 = TeamEntity("Spain")
        //SET TI SO
//        team4_1.numberGoalar = 0
//        team4_2.numberGoalar = 0
        match4.teams.add(team4_1)
        match4.teams.add(team4_2)
        matches.add(match4)

        var match5 = MatchEntity("2018-06-21 19:00 +0700", "Samara Arena", Constance.C)
        var team5_1 = TeamEntity("Denmark")
        var team5_2 = TeamEntity("Australia")
        //SET TI SO
//        team5_1.numberGoalar = 0
//        team5_2.numberGoalar = 0
        match5.teams.add(team5_1)
        match5.teams.add(team5_2)
        matches.add(match5)

        var match6 = MatchEntity("2018-06-21 22:00 +0700", "Ekaterinburg Arena", Constance.C)
        var team6_1 = TeamEntity("France")
        var team6_2 = TeamEntity("Peru")
        //SET TI SO
//        team6_1.numberGoalar = 0
//        team6_2.numberGoalar = 0
        match6.teams.add(team6_1)
        match6.teams.add(team6_2)
        matches.add(match6)

        var match7 = MatchEntity("2018-06-22 01:00 +0700", "Nizhny Novgorod Stadium", Constance.D)
        var team7_1 = TeamEntity("Argentina")
        var team7_2 = TeamEntity("Croatia")
        //SET TI SO
//        team7_1.numberGoalar = 0
//        team7_2.numberGoalar = 0
        match7.teams.add(team7_1)
        match7.teams.add(team7_2)
        matches.add(match7)

        var match8 = MatchEntity("2018-06-22 19:00 +0700", "Saint Petersburg Stadium", Constance.E)
        var team8_1 = TeamEntity("Brazil")
        var team8_2 = TeamEntity("Costa Rica")
        //SET TI SO
//        team8_1.numberGoalar = 0
//        team8_2.numberGoalar = 0
        match8.teams.add(team8_1)
        match8.teams.add(team8_2)
        matches.add(match8)

        var match9 = MatchEntity("2018-06-22 22:00 +0700", "Volgograd Arena", Constance.D)
        var team9_1 = TeamEntity("Nigeria")
        var team9_2 = TeamEntity("Iceland")
        //SET TI SO
//        team9_1.numberGoalar = 0
//        team9_2.numberGoalar = 0
        match9.teams.add(team9_1)
        match9.teams.add(team9_2)
        matches.add(match9)

        var match10 = MatchEntity("2018-06-23 01:00 +0700", "Kaliningrad Stadium", Constance.E)
        var team10_1 = TeamEntity("Serbia")
        var team10_2 = TeamEntity("Switzerland")
        //SET TI SO
//        team10_1.numberGoalar = 0
//        team10_2.numberGoalar = 0
        match10.teams.add(team10_1)
        match10.teams.add(team10_2)
        matches.add(match10)

        var match11 = MatchEntity("2018-06-23 19:00 +0700", "Spartak Stadium", Constance.G)
        var team11_1 = TeamEntity("Belgium")
        var team11_2 = TeamEntity("Tunisia")
        //SET TI SO
//        team11_1.numberGoalar = 0
//        team11_2.numberGoalar = 0
        match11.teams.add(team11_1)
        match11.teams.add(team11_2)
        matches.add(match11)

        var match12 = MatchEntity("2018-06-23 22:00 +0700", "Rostov Arena", Constance.F)
        var team12_1 = TeamEntity("South Korea")
        var team12_2 = TeamEntity("Mexico")
        //SET TI SO
//        team12_1.numberGoalar = 0
//        team12_2.numberGoalar = 0
        match12.teams.add(team12_1)
        match12.teams.add(team12_2)
        matches.add(match12)

        var match13 = MatchEntity("2018-06-24 01:00 +0700", "Fisht Stadium", Constance.F)
        var team13_1 = TeamEntity("Germany")
        var team13_2 = TeamEntity("Switzerland")
        //SET TI SO
//        team13_1.numberGoalar = 0
//        team13_2.numberGoalar = 0
        match13.teams.add(team13_1)
        match13.teams.add(team13_2)
        matches.add(match13)

        var match14 = MatchEntity("2018-06-24 19:00 +0700", "Nizhny Novgorod Stadium", Constance.G)
        var team14_1 = TeamEntity("England")
        var team14_2 = TeamEntity("Panama")
        //SET TI SO
//        team14_1.numberGoalar = 0
//        team14_2.numberGoalar = 0
        match14.teams.add(team14_1)
        match14.teams.add(team14_2)
        matches.add(match14)

        var match15 = MatchEntity("2018-06-24 22:00 +0700", "Ekaterinburg Arena", Constance.H)
        var team15_1 = TeamEntity("Japan")
        var team15_2 = TeamEntity("Senegal")
        //SET TI SO
//        team15_1.numberGoalar = 0
//        team15_2.numberGoalar = 0
        match15.teams.add(team15_1)
        match15.teams.add(team15_2)
        matches.add(match15)

        var match16 = MatchEntity("2018-06-25 01:00 +0700", "Kazan Arena", Constance.H)
        var team16_1 = TeamEntity("Poland")
        var team16_2 = TeamEntity("Colombia")
        //SET TI SO
//        team16_1.numberGoalar = 0
//        team16_2.numberGoalar = 0
        match16.teams.add(team16_1)
        match16.teams.add(team16_2)
        matches.add(match16)
        mDatabase?.child(userId)?.setValue(matches)
    }

    fun createDatabase3_3() {
        var matches = ArrayList<MatchEntity>()
        val userId = Constance.FIRST_STAGE_3_3
        var match1 = MatchEntity("2018-06-25 21:00 +0700", "Volgograd Arena", Constance.A)
        var team1_1 = TeamEntity("Saudi Arabia")
        var team1_2 = TeamEntity("Egypt")
        //SET TI SO
//        team1_1.numberGoalar = 0
//        team1_2.numberGoalar = 0
        match1.teams.add(team1_1)
        match1.teams.add(team1_2)
        matches.add(match1)

        var match2 = MatchEntity("2018-06-25 21:00 +0700", "Samara Arena", Constance.A)
        var team2_1 = TeamEntity("Uruguay")
        var team2_2 = TeamEntity("Russia")
        //SET TI SOA
//        team2_1.numberGoalar = 0
//        team2_2.numberGoalar = 0
        match2.teams.add(team2_1)
        match2.teams.add(team2_2)
        matches.add(match2)

        var match3 = MatchEntity("2018-06-26 01:00 +0700", "Mordovia Arena", Constance.B)
        var team3_1 = TeamEntity("Iran")
        var team3_2 = TeamEntity("Portugal")
        //SET TI SO
//        team3_1.numberGoalar = 0
//        team3_2.numberGoalar = 0
        match3.teams.add(team3_1)
        match3.teams.add(team3_2)
        matches.add(match3)

        var match4 = MatchEntity("2018-06-26 01:00 +0700", "Kaliningrad Stadium", Constance.B)
        var team4_1 = TeamEntity("Spain")
        var team4_2 = TeamEntity("Morocco")
        //SET TI SO
//        team4_1.numberGoalar = 0
//        team4_2.numberGoalar = 0
        match4.teams.add(team4_1)
        match4.teams.add(team4_2)
        matches.add(match4)

        var match5 = MatchEntity("2018-06-26 21:00 +0700", "Luzhniki Stadium", Constance.C)
        var team5_1 = TeamEntity("Denmark")
        var team5_2 = TeamEntity("France")
        //SET TI SO
//        team5_1.numberGoalar = 0
//        team5_2.numberGoalar = 0
        match5.teams.add(team5_1)
        match5.teams.add(team5_2)
        matches.add(match5)

        var match6 = MatchEntity("2018-06-26 21:00 +0700", "Fisht Stadium", Constance.C)
        var team6_1 = TeamEntity("Australia")
        var team6_2 = TeamEntity("Peru")
        //SET TI SO
//        team6_1.numberGoalar = 0
//        team6_2.numberGoalar = 0
        match6.teams.add(team6_1)
        match6.teams.add(team6_2)
        matches.add(match6)

        var match7 = MatchEntity("2018-06-27 01:00 +0700", "Saint Petersburg Stadium", Constance.D)
        var team7_1 = TeamEntity("Nigeria")
        var team7_2 = TeamEntity("Argentina")
        //SET TI SO
//        team7_1.numberGoalar = 0
//        team7_2.numberGoalar = 0
        match7.teams.add(team7_1)
        match7.teams.add(team7_2)
        matches.add(match7)

        var match8 = MatchEntity("2018-06-27 01:00 +0700", "Rostov Arena", Constance.D)
        var team8_1 = TeamEntity("Iceland")
        var team8_2 = TeamEntity("Croatia")
        //SET TI SO
//        team8_1.numberGoalar = 0
//        team8_2.numberGoalar = 0
        match8.teams.add(team8_1)
        match8.teams.add(team8_2)
        matches.add(match8)

        var match9 = MatchEntity("2018-06-27 21:00 +0700", "Ekaterinburg Arena", Constance.F)
        var team9_1 = TeamEntity("Mexico")
        var team9_2 = TeamEntity("Switzerland")
        //SET TI SO
//        team9_1.numberGoalar = 0
//        team9_2.numberGoalar = 0
        match9.teams.add(team9_1)
        match9.teams.add(team9_2)
        matches.add(match9)

        var match10 = MatchEntity("2018-06-27 21:00 +0700", "Kazan Arena", Constance.F)
        var team10_1 = TeamEntity("South Korea")
        var team10_2 = TeamEntity("Germany")
        //SET TI SO
//        team10_1.numberGoalar = 0
//        team10_2.numberGoalar = 0
        match10.teams.add(team10_1)
        match10.teams.add(team10_2)
        matches.add(match10)

        var match11 = MatchEntity("2018-06-28 01:00 +0700", "Spartak Stadium", Constance.E)
        var team11_1 = TeamEntity("Serbia")
        var team11_2 = TeamEntity("Brazil")
        //SET TI SO
//        team11_1.numberGoalar = 0
//        team11_2.numberGoalar = 0
        match11.teams.add(team11_1)
        match11.teams.add(team11_2)
        matches.add(match11)

        var match12 = MatchEntity("2018-06-28 01:00 +0700", "Nizhny Novgorod Stadium", Constance.E)
        var team12_1 = TeamEntity("Switzerland")
        var team12_2 = TeamEntity("Costa Rica")
        //SET TI SO
//        team12_1.numberGoalar = 0
//        team12_2.numberGoalar = 0
        match12.teams.add(team12_1)
        match12.teams.add(team12_2)
        matches.add(match12)

        var match13 = MatchEntity("2018-06-28 21:00 +0700", "Volgograd Arena", Constance.H)
        var team13_1 = TeamEntity("Japan")
        var team13_2 = TeamEntity("Poland")
        //SET TI SO
//        team13_1.numberGoalar = 0
//        team13_2.numberGoalar = 0
        match13.teams.add(team13_1)
        match13.teams.add(team13_2)
        matches.add(match13)

        var match14 = MatchEntity("2018-06-28 21:00 +0700", "Samara Arena", Constance.H)
        var team14_1 = TeamEntity("Senegal")
        var team14_2 = TeamEntity("Colombia")
        //SET TI SO
//        team14_1.numberGoalar = 0
//        team14_2.numberGoalar = 0
        match14.teams.add(team14_1)
        match14.teams.add(team14_2)
        matches.add(match14)

        var match15 = MatchEntity("2018-06-29 01:00 +0700", "Mordovia Arena", Constance.G)
        var team15_1 = TeamEntity("Panama")
        var team15_2 = TeamEntity("Tunisia")
        //SET TI SO
//        team15_1.numberGoalar = 0
//        team15_2.numberGoalar = 0
        match15.teams.add(team15_1)
        match15.teams.add(team15_2)
        matches.add(match15)

        var match16 = MatchEntity("2018-06-29 01:00 +0700", "Kaliningrad Stadium", Constance.G)
        var team16_1 = TeamEntity("England")
        var team16_2 = TeamEntity("Belgium")
        //SET TI SO
//        team16_1.numberGoalar = 0
//        team16_2.numberGoalar = 0
        match16.teams.add(team16_1)
        match16.teams.add(team16_2)
        matches.add(match16)
        mDatabase?.child(userId)?.setValue(matches)
    }

    fun setValues(name: String, matches: Int, matchW: Int, matchD: Int, recordGoal: Int, allowGoal: Int): TeamSortEntity {
        var teamSort = TeamSortEntity(name)
        teamSort.matches = matches
        teamSort.matchW = matchW
        teamSort.matchD = matchD
        teamSort.recordGoals = recordGoal
        teamSort.allowGoals = allowGoal
        return teamSort
    }

    fun createGroupA() {
        var teamSort = ArrayList<TeamSortEntity>()
        val Id = Constance.A
        for (i in 0..3) {
            when (i) {
                0 -> {
                    teamSort.add(setValues("Egypt", 0, 0, 0, 0, 0))
                }
                1 -> {
                    teamSort.add(setValues("Russia", 0, 0, 0, 0, 0))
                }
                2 -> {
                    teamSort.add(setValues("Saudi Arabia", 0, 0, 0, 0, 0))
                }
                3 -> {
                    teamSort.add(setValues("Uruguay", 0, 0, 0, 0, 0))
                }
            }
        }
        mDatabase?.child(Id)?.setValue(teamSort)
    }

    fun createGroupB() {
        var teamSort = ArrayList<TeamSortEntity>()
        val Id = Constance.B
        for (i in 0..3) {
            when (i) {
                0 -> {
                    teamSort.add(setValues("Iran", 0, 0, 0, 0, 0))
                }
                1 -> {
                    teamSort.add(setValues("Morocco", 0, 0, 0, 0, 0))
                }
                2 -> {
                    teamSort.add(setValues("Portugal", 0, 0, 0, 0, 0))
                }
                3 -> {
                    teamSort.add(setValues("Spain", 0, 0, 0, 0, 0))
                }
            }
        }
        mDatabase?.child(Id)?.setValue(teamSort)
    }

    fun createGroupC() {
        var teamSort = ArrayList<TeamSortEntity>()
        val Id = Constance.C
        for (i in 0..3) {
            when (i) {
                0 -> {
                    teamSort.add(setValues("Australia", 0, 0, 0, 0, 0))
                }
                1 -> {
                    teamSort.add(setValues("Denmark", 0, 0, 0, 0, 0))
                }
                2 -> {
                    teamSort.add(setValues("France", 0, 0, 0, 0, 0))
                }
                3 -> {
                    teamSort.add(setValues("Peru", 0, 0, 0, 0, 0))
                }
            }
        }
        mDatabase?.child(Id)?.setValue(teamSort)
    }

    fun createGroupD() {
        var teamSort = ArrayList<TeamSortEntity>()
        val Id = Constance.D
        for (i in 0..3) {
            when (i) {
                0 -> {
                    teamSort.add(setValues("Argentina", 0, 0, 0, 0, 0))
                }
                1 -> {
                    teamSort.add(setValues("Croatia", 0, 0, 0, 0, 0))
                }
                2 -> {
                    teamSort.add(setValues("Iceland", 0, 0, 0, 0, 0))
                }
                3 -> {
                    teamSort.add(setValues("Nigeria", 0, 0, 0, 0, 0))
                }
            }
        }
        mDatabase?.child(Id)?.setValue(teamSort)
    }

    fun createGroupE() {
        var teamSort = ArrayList<TeamSortEntity>()
        val Id = Constance.E
        for (i in 0..3) {
            when (i) {
                0 -> {
                    teamSort.add(setValues("Brazil", 0, 0, 0, 0, 0))
                }
                1 -> {
                    teamSort.add(setValues("Costa Rica", 0, 0, 0, 0, 0))
                }
                2 -> {
                    teamSort.add(setValues("Switzerland", 0, 0, 0, 0, 0))
                }
                3 -> {
                    teamSort.add(setValues("Serbia", 0, 0, 0, 0, 0))
                }
            }
        }
        mDatabase?.child(Id)?.setValue(teamSort)
    }

    fun createGroupF() {
        var teamSort = ArrayList<TeamSortEntity>()
        val Id = Constance.F
        for (i in 0..3) {
            when (i) {
                0 -> {
                    teamSort.add(setValues("Germany", 0, 0, 0, 0, 0))
                }
                1 -> {
                    teamSort.add(setValues("South Korea", 0, 0, 0, 0, 0))
                }
                2 -> {
                    teamSort.add(setValues("Mexico", 0, 0, 0, 0, 0))
                }
                3 -> {
                    teamSort.add(setValues("Sweden", 0, 0, 0, 0, 0))
                }
            }
        }
        mDatabase?.child(Id)?.setValue(teamSort)
    }

    fun createGroupG() {
        var teamSort = ArrayList<TeamSortEntity>()
        val Id = Constance.G
        for (i in 0..3) {
            when (i) {
                0 -> {
                    teamSort.add(setValues("Belgium", 0, 0, 0, 0, 0))
                }
                1 -> {
                    teamSort.add(setValues("England", 0, 0, 0, 0, 0))
                }
                2 -> {
                    teamSort.add(setValues("Panama", 0, 0, 0, 0, 0))
                }
                3 -> {
                    teamSort.add(setValues("Tunisia", 0, 0, 0, 0, 0))
                }
            }
        }
        mDatabase?.child(Id)?.setValue(teamSort)
    }

    fun createGroupH() {
        var teamSort = ArrayList<TeamSortEntity>()
        val Id = Constance.H
        for (i in 0..3) {
            when (i) {
                0 -> {
                    teamSort.add(setValues("Colombia", 0, 0, 0, 0, 0))
                }
                1 -> {
                    teamSort.add(setValues("Japan", 0, 0, 0, 0, 0))
                }
                2 -> {
                    teamSort.add(setValues("Poland", 0, 0, 0, 0, 0))
                }
                3 -> {
                    teamSort.add(setValues("Senegal", 0, 0, 0, 0, 0))
                }
            }
        }
        mDatabase?.child(Id)?.setValue(teamSort)
    }

    // round of 16
    fun createDb1_16() {
        var matches = ArrayList<MatchEntity>()
        val userId = Constance.FIRST_STAGE_1_16
        var match1 = MatchEntity("2018-06-30 21:00 +0700", "Kazan Arena", "Match 49")
        var team1_1 = TeamEntity("1C")
        var team1_2 = TeamEntity("2D")
        //SET TI SO
//        team1_1.numberGoalar = 0
//        team1_2.numberGoalar = 0
        match1.teams.add(team1_1)
        match1.teams.add(team1_2)
        matches.add(match1)

        var match2 = MatchEntity("2018-07-01 01:00 +0700", "Fisht Stadium", "Match 50")
        var team2_1 = TeamEntity("1A")
        var team2_2 = TeamEntity("2B")
        //SET TI SOA
//        team2_1.numberGoalar = 0
//        team2_2.numberGoalar = 0
        match2.teams.add(team2_1)
        match2.teams.add(team2_2)
        matches.add(match2)

        var match3 = MatchEntity("2018-07-01 21:00 +0700", "Luzhniki Stadium", "Match 51")
        var team3_1 = TeamEntity("1B")
        var team3_2 = TeamEntity("2A")
        //SET TI SO
//        team3_1.numberGoalar = 0
//        team3_2.numberGoalar = 0
        match3.teams.add(team3_1)
        match3.teams.add(team3_2)
        matches.add(match3)

        var match4 = MatchEntity("2018-07-02 01:00 +0700", "Nizhny Novgorod Stadiuma", "Match 52")
        var team4_1 = TeamEntity("1D")
        var team4_2 = TeamEntity("2C")
        //SET TI SO
//        team4_1.numberGoalar = 0
//        team4_2.numberGoalar = 0
        match4.teams.add(team4_1)
        match4.teams.add(team4_2)
        matches.add(match4)

        var match5 = MatchEntity("2018-07-02 21:00 +0700", "Samara Arena", "Match 53")
        var team5_1 = TeamEntity("1E")
        var team5_2 = TeamEntity("2F")
        //SET TI SO
//        team5_1.numberGoalar = 0
//        team5_2.numberGoalar = 0
        match5.teams.add(team5_1)
        match5.teams.add(team5_2)
        matches.add(match5)

        var match6 = MatchEntity("2018-07-03 01:00 +0700", "Rostov Arena", "Match 54")
        var team6_1 = TeamEntity("1G")
        var team6_2 = TeamEntity("2H")
        //SET TI SO
//        team6_1.numberGoalar = 0
//        team6_2.numberGoalar = 0
        match6.teams.add(team6_1)
        match6.teams.add(team6_2)
        matches.add(match6)

        var match7 = MatchEntity("2018-07-03 21:00 +0700", "Saint Petersburg Stadium", "Match 55")
        var team7_1 = TeamEntity("1F")
        var team7_2 = TeamEntity("2E")
        //SET TI SO
//        team7_1.numberGoalar = 0
//        team7_2.numberGoalar = 0
        match7.teams.add(team7_1)
        match7.teams.add(team7_2)
        matches.add(match7)

        var match8 = MatchEntity("2018-07-04 01:00 +0700", "Spartak Stadium", "Match 56")
        var team8_1 = TeamEntity("1H")
        var team8_2 = TeamEntity("2G")
        //SET TI SO
//        team8_1.numberGoalar = 0
//        team8_2.numberGoalar = 0
        match8.teams.add(team8_1)
        match8.teams.add(team8_2)
        matches.add(match8)

        mDatabase?.child(userId)?.setValue(matches)
    }

    //QUARTER-FINALS
    fun createDbQF() {
        var matches = ArrayList<MatchEntity>()
        val userId = Constance.QUARTER_FINALS
        var match1 = MatchEntity("2018-07-06 21:00 +0700", "Nizhny Novgorod Stadium", "Match 57")
        var team1_1 = TeamEntity("W49")
        var team1_2 = TeamEntity("W50")
        //SET TI SO
//        team1_1.numberGoalar = 0
//        team1_2.numberGoalar = 0
        match1.teams.add(team1_1)
        match1.teams.add(team1_2)
        matches.add(match1)

        var match2 = MatchEntity("2018-07-07 01:00 +0700", "Kazan Arena", "Match 58")
        var team2_1 = TeamEntity("W53")
        var team2_2 = TeamEntity("W54")
        //SET TI SOA
//        team2_1.numberGoalar = 0
//        team2_2.numberGoalar = 0
        match2.teams.add(team2_1)
        match2.teams.add(team2_2)
        matches.add(match2)

        var match3 = MatchEntity("2018-07-07 21:00 +0700", "Samara Arena", "Match 59")
        var team3_1 = TeamEntity("W55")
        var team3_2 = TeamEntity("W56")
        //SET TI SO
//        team3_1.numberGoalar = 0
//        team3_2.numberGoalar = 0
        match3.teams.add(team3_1)
        match3.teams.add(team3_2)
        matches.add(match3)

        var match4 = MatchEntity("2018-07-08 01:00 +0700", "Fisht Stadium", "Match 60")
        var team4_1 = TeamEntity("W51")
        var team4_2 = TeamEntity("W52")
        //SET TI SO
//        team4_1.numberGoalar = 0
//        team4_2.numberGoalar = 0
        match4.teams.add(team4_1)
        match4.teams.add(team4_2)
        matches.add(match4)
        mDatabase?.child(userId)?.setValue(matches)
    }

    //QUARTER-FINALS
    fun createDbSF() {
        var matches = ArrayList<MatchEntity>()
        val userId = Constance.SEMI_FINALS
        var match1 = MatchEntity("2018-07-11 01:00 +0700", "Saint Petersburg Stadium", "Match 61")
        var team1_1 = TeamEntity("W57")
        var team1_2 = TeamEntity("W58")
        //SET TI SO
//        team1_1.numberGoalar = 0
//        team1_2.numberGoalar = 0
        match1.teams.add(team1_1)
        match1.teams.add(team1_2)
        matches.add(match1)

        var match2 = MatchEntity("2018-07-12 01:00 +0700", "Luzhniki Stadium", "Match 62")
        var team2_1 = TeamEntity("W59")
        var team2_2 = TeamEntity("W60")
        //SET TI SOA
//        team2_1.numberGoalar = 0
//        team2_2.numberGoalar = 0
        match2.teams.add(team2_1)
        match2.teams.add(team2_2)
        matches.add(match2)
        mDatabase?.child(userId)?.setValue(matches)
    }
    //QUARTER-FINALS
    fun createDbFN() {
        var matches = ArrayList<MatchEntity>()
        val userId = Constance.FINAL
        var match1 = MatchEntity("2018-07-14 21:00 +0700", "Saint Petersburg Stadium", "Match 61")
        var team1_1 = TeamEntity("L61")
        var team1_2 = TeamEntity("L62")
        //SET TI SO
//        team1_1.numberGoalar = 0
//        team1_2.numberGoalar = 0
        match1.teams.add(team1_1)
        match1.teams.add(team1_2)
        matches.add(match1)

        var match2 = MatchEntity("2018-07-15 22:00 +0700", "Luzhniki Stadium", "Match 62")
        var team2_1 = TeamEntity("W61")
        var team2_2 = TeamEntity("W62")
        //SET TI SOA
//        team2_1.numberGoalar = 0
//        team2_2.numberGoalar = 0
        match2.teams.add(team2_1)
        match2.teams.add(team2_2)
        matches.add(match2)
        mDatabase?.child(userId)?.setValue(matches)
    }

    fun createDBStadium(){
        val userId = Constance.STADIUM
        var stadiums = ArrayList<StadiumEntity>()
        var sta1 = StadiumEntity("Luzhniki Stadium")
        sta1.city = "Moscow"
        sta1.capacity = "81.006"
        stadiums.add(sta1)

        var sta2 = StadiumEntity("Ekaterinburg Arena")
        sta2.city = "Ekaterinburg"
        sta2.capacity = "35.696"
        stadiums.add(sta2)

        var sta3 = StadiumEntity("Kaliningrad Stadium")
        sta3.city = "Kaliningrad"
        sta3.capacity = "35.212"
        stadiums.add(sta3)

        var sta4 = StadiumEntity("Kazan Arena")
        sta4.city = "Kazan"
        sta4.capacity = "44.779"
        stadiums.add(sta4)

        var sta5 = StadiumEntity("Spartak Stadium")
        sta5.city = "Moscow"
        sta5.capacity = "43.298"
        stadiums.add(sta5)

        var sta6 = StadiumEntity("Nizhny Novgorod Stadium")
        sta6.city = "Novgorod"
        sta6.capacity = "45.331"
        stadiums.add(sta6)

        var sta7 = StadiumEntity("Rostov Arena")
        sta7.city = "Rostov-on-Don"
        sta7.capacity = "45.145"
        stadiums.add(sta7)

        var sta8 = StadiumEntity("Saint Petersburg Stadium")
        sta8.city = "Saint Petersburg"
        sta8.capacity = "68.134"
        stadiums.add(sta8)

        var sta9 = StadiumEntity("Samara Arena")
        sta9.city = "Samara"
        sta9.capacity = "44.807"
        stadiums.add(sta9)

        var sta10 = StadiumEntity("Mordovia Arena")
        sta10.city = "Saransk"
        sta10.capacity = "44.442"
        stadiums.add(sta10)

        var sta11 = StadiumEntity("Fisht Stadium")
        sta11.city = "Sochi"
        sta11.capacity = "47.700"
        stadiums.add(sta11)

        var sta12 = StadiumEntity("Volgograd Arena")
        sta12.city = "Volgograd"
        sta12.capacity = "45.568"
        stadiums.add(sta12)

        mDatabase?.child(userId)?.setValue(stadiums)
    }
}